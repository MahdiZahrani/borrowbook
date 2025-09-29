package ir.mzahrani.service;

import ir.mzahrani.entity.Book;
import ir.mzahrani.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(Long id){
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByTitle(keyword);
    }

}
