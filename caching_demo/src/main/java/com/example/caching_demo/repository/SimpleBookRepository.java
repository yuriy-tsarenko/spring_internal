package com.example.caching_demo.repository;

import com.example.caching_demo.model.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        UUID uuid = UUID.randomUUID();
        return new Book(isbn, uuid.toString());
    }

    @CachePut("books")
    public Book updateBook(String isbn) {
        simulateSlowService();
        UUID uuid = UUID.randomUUID();
        return new Book(isbn, uuid.toString());
    }

    @CacheEvict(cacheNames = {"books"}, allEntries = true)
    public void clearCache() {
        //some code
    }

    @CacheEvict("books")
    public void clearCache(String isbn) {
        //some code
    }


    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}