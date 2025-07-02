package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void processBook() {
        System.out.println("🔧 Processing book in service...");
        bookRepository.saveBook();
    }
}
