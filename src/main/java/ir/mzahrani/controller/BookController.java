package ir.mzahrani.controller;

import ir.mzahrani.entity.Book;
import ir.mzahrani.service.Impl.BookServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@AllArgsConstructor

public class BookController {
    private final BookServiceImpl bookService;

//    @GetMapping
//    public ResponseEntity<List<Book>> getAllBooks() {
//        return ResponseEntity.ok().body(bookService.getAllBooks());
//    }
//
//    @PostMapping
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        bookService.addBook(book);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

}
