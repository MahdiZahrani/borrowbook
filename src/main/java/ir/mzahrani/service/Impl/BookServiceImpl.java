package ir.mzahrani.service.Impl;

import ir.mzahrani.entity.Book;
import ir.mzahrani.repository.BookRepository;
import ir.mzahrani.service.BookServiceInterface;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl extends BaseService<Book,Long> implements BookServiceInterface {

    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        super(bookRepository);
        this.bookRepository = bookRepository;
    }

}
