package com.lab2.backend.repository;

import com.lab2.backend.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    ArrayList<Book> findByName(String name);
    ArrayList<Book> findByAuthorName(String authorName);
    ArrayList<Book> findByAnnotation(String annotation);

}
