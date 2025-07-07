package com.library.repository;

import com.library.entity.Book;
import org.spring.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}