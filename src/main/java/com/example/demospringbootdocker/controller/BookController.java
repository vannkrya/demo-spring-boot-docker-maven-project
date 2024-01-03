package com.example.demospringbootdocker.controller;

import com.example.demospringbootdocker.entity.Book;
import com.example.demospringbootdocker.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping("/message")
    public String getMessage() {
        return "hello bro!";
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<?> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return ResponseEntity.ok().body(bookList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody Book bookRequest) {
        Book book = bookRepository.save(bookRequest);
        return ResponseEntity.ok().body(book);
    }
}
