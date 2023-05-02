package com.jeremias.dev.bussines.libros.repository;

import com.jeremias.dev.bussines.libros.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthor(String author);
    Optional<Book> findByTitle(String title);

}
