package com.lab2.backend.configuration;


import com.lab2.backend.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {
    @Bean
    @Scope("prototype")
    public Book getBook() {
        return new Book();
    }


}
