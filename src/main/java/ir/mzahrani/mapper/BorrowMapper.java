package ir.mzahrani.mapper;

import ir.mzahrani.config.BusinessConstants;
import ir.mzahrani.dto.BorrowRequestDTO;
import ir.mzahrani.dto.BorrowResponseDTO;
import ir.mzahrani.entity.Book;
import ir.mzahrani.entity.Borrow;
import ir.mzahrani.entity.Member;

import java.time.LocalDate;

public class BorrowMapper {


    public static Borrow toEntity(BorrowRequestDTO dto, Book book, Member member) {
        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setMember(member);
        borrow.setStartDate(LocalDate.now());
        borrow.setDueDate(LocalDate.now().plusDays(BusinessConstants.BORROW_PERIOD_DAYS));
        return borrow;
    }
    
    public static BorrowResponseDTO toResponse(String message, Borrow borrow) {
        BorrowResponseDTO borrowResponseDTO = new BorrowResponseDTO(); 
        borrowResponseDTO.setMessage(message);
        borrowResponseDTO.setDueDate(borrow != null ? borrow.getDueDate() : null);
        return borrowResponseDTO;
    }
}
