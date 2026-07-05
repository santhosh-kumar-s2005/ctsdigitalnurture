package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService created via constructor injection.");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository set via setter injection.");
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
