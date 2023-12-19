package com.power.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "product")
public class BookContainer {

    private List<Book>  books;

    public BookContainer() {
    }

    public BookContainer(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookContainer{" +
                "books=" + books +
                '}';
    }
}
