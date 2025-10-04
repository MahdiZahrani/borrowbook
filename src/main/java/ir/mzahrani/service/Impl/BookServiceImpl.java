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
@AllArgsConstructor

public class BookServiceImpl implements BookServiceInterface {

    private final BookRepository bookRepository;

    @Override
    public Book create(Book entity) {
        return null;
    }

    @Override
    public Book update(Book entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Book get(Long aLong) {
        return null;
    }
//
//    @Override
//    public List<Book> getAll() {
//        return List.of();
//    }
}
