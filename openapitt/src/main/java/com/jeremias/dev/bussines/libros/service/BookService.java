package com.jeremias.dev.bussines.libros.service;

import com.jeremias.dev.bussines.libros.controller.dto.BookRequest;
import com.jeremias.dev.bussines.libros.controller.dto.BookResponse;

import java.util.List;

public interface BookService {
    public void create(BookRequest obj);

    public List<BookResponse> list();
}
