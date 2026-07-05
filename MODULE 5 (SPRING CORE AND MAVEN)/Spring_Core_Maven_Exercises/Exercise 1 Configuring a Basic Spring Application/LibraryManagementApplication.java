package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println("Spring context loaded successfully.");
        System.out.println("BookService bean: " + bookService);
        ((ClassPathXmlApplicationContext) context).close();
    }
}
