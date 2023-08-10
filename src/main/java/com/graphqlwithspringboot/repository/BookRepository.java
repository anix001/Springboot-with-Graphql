package com.graphqlwithspringboot.repository;

import com.graphqlwithspringboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
