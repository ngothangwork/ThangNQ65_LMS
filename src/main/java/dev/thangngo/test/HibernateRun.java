package dev.thangngo.test;

import dev.thangngo.entities.Book;
import dev.thangngo.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateRun {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean(BookService.class);

        Book book = new Book("Java Core", "Computer Science", true, null, null);
        bookService.createOrUpdate(book);

        System.out.println("Danh sách sách:");
        bookService.getAllBooks().forEach(
                b -> System.out.println(b.getId() + " - " + b.getTitle())
        );


        ((ClassPathXmlApplicationContext) context).close();
    }
}

