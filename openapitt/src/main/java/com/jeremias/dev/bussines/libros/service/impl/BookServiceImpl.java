package com.jeremias.dev.bussines.libros.service.impl;

import com.jeremias.dev.bussines.libros.controller.dto.BookRequest;
import com.jeremias.dev.bussines.libros.controller.dto.BookResponse;
import com.jeremias.dev.bussines.libros.mapper.BookMapper;
import com.jeremias.dev.bussines.libros.repository.BookRepository;
import com.jeremias.dev.bussines.libros.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    @Override
    public void create(BookRequest obj) {
        bookRepository.save( bookMapper.toEntity(obj));
    }

    @Override
    public List<BookResponse> list() {
        return bookRepository.findAll().stream().map(bookMapper::toResponse).collect(Collectors.toList());
    }
}
