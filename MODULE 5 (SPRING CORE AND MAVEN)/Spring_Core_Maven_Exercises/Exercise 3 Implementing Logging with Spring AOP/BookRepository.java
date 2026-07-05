package com.library.repository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Clean Code");
        books.add("The Pragmatic Programmer");
        books.add("Design Patterns");
    }

    public List<String> findAllBooks() {
        return books;
    }
}
