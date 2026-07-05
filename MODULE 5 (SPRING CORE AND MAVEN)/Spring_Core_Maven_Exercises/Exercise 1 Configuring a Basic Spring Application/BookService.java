package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public List<String> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public void printAllBooks() {
        System.out.println("Books in library:");
        for (String book : getAllBooks()) {
            System.out.println(" - " + book);
        }
    }
}
