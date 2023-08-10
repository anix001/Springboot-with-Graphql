package com.graphqlwithspringboot.resource;

import com.graphqlwithspringboot.domain.Book;
import com.graphqlwithspringboot.domain.dto.BookInput;
import com.graphqlwithspringboot.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResource {
    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> books(){
        return bookService.books();
    }

    @QueryMapping
    public Book bookById(@Argument Long bookId){
        return bookService.bookById(bookId);
    }

    @MutationMapping(name = "storeBookToDb")
    public Book storeBookToDb(@Argument(name = "book") BookInput bookInput){
       Book newBook = new Book();
        newBook.setAuthor(bookInput.getAuthor());
       newBook.setTitle(bookInput.getTitle());
       newBook.setDescription(bookInput.getDescription());
       newBook.setPrice(bookInput.getPrice());
       newBook.setPages(bookInput.getPages());
       return bookService.storeBookToDb(newBook);
    }

    @MutationMapping
    public Book updateBookToDb(@Argument Long bookId, @Argument(name = "book") BookInput bookInput){
        Book newBook = new Book();
        newBook.setAuthor(bookInput.getAuthor());
        newBook.setTitle(bookInput.getTitle());
        newBook.setDescription(bookInput.getDescription());
        newBook.setPrice(bookInput.getPrice());
        newBook.setPages(bookInput.getPages());
        return bookService.updateBook(bookId, newBook);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long bookId){
        bookService.deleteBook(bookId);
        return true;
    }
}

