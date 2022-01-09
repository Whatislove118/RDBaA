package com.lab2.backend.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String authorName;

    private String genreName;

    private Date dateOfPublished = new Date(System.currentTimeMillis());

    private String annotation;

    private String ISBN;


    public Book() {
    }
}
