package ir.mzahrani.repository;

import ir.mzahrani.entity.Book;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
    }

    @Test
    void testSaveAndFindById() {
        Book book = new Book();
        book.setTitle("Hibernate Basics");

        bookRepository.save(book);

        Book found = bookRepository.findById(book.getId());
        assertNotNull(found);
        assertEquals("Hibernate Basics", found.getTitle());
    }

    @Test
    void testFindByTitle() {
        Book book = new Book();
        book.setTitle("Spring in Action");
        bookRepository.save(book);


        List<Book> result = bookRepository.findByTitle("Spring");
        assertFalse(result.isEmpty());
        assertEquals("Spring in Action", result.get(0).getTitle());
    }
}
