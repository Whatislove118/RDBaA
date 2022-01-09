package com.lab2.backend.controllers;


import com.lab2.backend.entity.Book;
import com.lab2.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<Book> searchBook(@RequestParam(required = false) String name, @RequestParam(required = false) String authorName, @RequestParam(required = false) String keywords) {
        ArrayList<Book> book_from_db;
        if (name != null) {
            book_from_db = bookRepository.findByName(name);
        } else if (authorName != null) {
            book_from_db = bookRepository.findByAuthorName(authorName);
        } else if (keywords != null) {
            book_from_db = bookRepository.findByAnnotation(keywords);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(book_from_db, HttpStatus.OK);


    }
}
