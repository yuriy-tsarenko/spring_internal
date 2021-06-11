package com.example.caching_demo.repository;

import com.example.caching_demo.model.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

    Book updateBook(String isbn);

    void clearCache(String isbn);

    void clearCache();

}