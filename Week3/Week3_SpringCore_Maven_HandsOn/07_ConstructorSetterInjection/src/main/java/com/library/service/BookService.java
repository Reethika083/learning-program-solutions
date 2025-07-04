package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        System.out.println("📦 BookService created with constructor injection.");
        this.bookRepository = bookRepository;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("📦 BookRepository set via setter injection.");
        this.bookRepository = bookRepository;
    }

    public void processBook() {
        System.out.println("📚 Processing book...");
        bookRepository.save();
    }
}
