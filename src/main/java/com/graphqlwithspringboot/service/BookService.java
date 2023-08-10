package com.graphqlwithspringboot.service;

import com.graphqlwithspringboot.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> books();
    Book bookById(Long bookId);
    Book storeBookToDb(Book book);
    Book updateBook(Long bookId,Book book);
    void deleteBook(Long bookId);
}
