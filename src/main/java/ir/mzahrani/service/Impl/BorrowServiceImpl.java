package ir.mzahrani.service.Impl;

import ir.mzahrani.config.BusinessConstants;
import ir.mzahrani.dto.BorrowRequestDTO;
import ir.mzahrani.dto.BorrowResponseDTO;
import ir.mzahrani.entity.*;
import ir.mzahrani.exception.*;
import ir.mzahrani.mapper.BorrowMapper;
import ir.mzahrani.repository.BookRepository;
import ir.mzahrani.repository.BorrowRepository;
import ir.mzahrani.repository.MemberRepository;
import ir.mzahrani.repository.WaitingListRepository;
import ir.mzahrani.service.BorrowServiceInterface;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class BorrowServiceImpl extends BaseService<Borrow,Long> implements BorrowServiceInterface {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final WaitingListRepository waitingListRepository;

    BorrowServiceImpl(BorrowRepository borrowRepository,
                      BookRepository bookRepository,
                      MemberRepository memberRepository,
                      WaitingListRepository waitingListRepository
    ) {

        super(borrowRepository);
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.waitingListRepository = waitingListRepository;
    }

    @Override
    @Transactional
    public BorrowResponseDTO borrowBook(BorrowRequestDTO borrowBookDto) {
        Book book = bookRepository.findById(borrowBookDto.getBookId()).orElseThrow(BookNotFoundException::new);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = memberRepository.findById(currentUser.getId())
                .orElseThrow(MemberNotFoundException::new);

        if(member.getBalance() == null && member.getBalance() <
                (BusinessConstants.BORROW_COST_DAILY * BusinessConstants.BORROW_PERIOD_DAYS) ){
            throw new InsufficientBalanceException();
        }

        try {
            if(book.getAvailableCopies() > 0){
                book.setAvailableCopies(book.getAvailableCopies() - 1);
                bookRepository.save(book);
                Borrow borrow = BorrowMapper.toEntity(borrowBookDto,book,member);
                borrowRepository.save(borrow);
                return BorrowMapper.toResponse("Successfully borrowed a book.",borrow);
            }else {
                if (!waitingListRepository.existsByBookAndMember(book, member)) {
                    WaitingList waiting = new WaitingList();
                    waiting.setBook(book);
                    waiting.setMember(member);
                    waiting.setRequestDate(LocalDate.now());
                    waitingListRepository.save(waiting);
                    throw new BookUnavailableException();
                } else {
                    throw new AlreadyInWaitingListException();
                }
            }
        }catch (Exception e){
            throw new ConcurrentBorrowException();
        }

    }
}
