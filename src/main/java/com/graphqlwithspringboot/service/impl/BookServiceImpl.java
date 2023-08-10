package com.graphqlwithspringboot.service.impl;

import com.graphqlwithspringboot.domain.Book;
import com.graphqlwithspringboot.repository.BookRepository;
import com.graphqlwithspringboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @Override
    public Book bookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new IllegalStateException("Book with id "+ bookId + " is not available in the db."));
    }

    @Override
    public Book storeBookToDb(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        Book dbBook = bookRepository.findById(bookId).orElseThrow(()-> new IllegalStateException("Book with id "+ bookId + " is not available in the db."));
        dbBook.setPages(Objects.nonNull(book.getPages())? book.getPages() : dbBook.getPages());
        dbBook.setTitle(Objects.nonNull(book.getTitle())? book.getTitle() : dbBook.getTitle());
        dbBook.setDescription(Objects.nonNull(book.getDescription())? book.getDescription() : dbBook.getDescription());
        dbBook.setAuthor(Objects.nonNull(book.getAuthor())? book.getAuthor() : dbBook.getAuthor());
        dbBook.setPrice(Objects.nonNull(book.getPrice())? book.getPrice() : dbBook.getPrice());
        return bookRepository.save(dbBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.findById(bookId).orElseThrow(()-> new IllegalStateException("Book with id "+ bookId + " is not available in the db."));
        bookRepository.deleteById(bookId);
    }
}
