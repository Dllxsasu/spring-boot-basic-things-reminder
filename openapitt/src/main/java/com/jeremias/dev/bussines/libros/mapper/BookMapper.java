package com.jeremias.dev.bussines.libros.mapper;

import com.jeremias.dev.bussines.libros.controller.dto.BookRequest;
import com.jeremias.dev.bussines.libros.controller.dto.BookResponse;
import com.jeremias.dev.bussines.libros.models.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    public Book toEntity(BookRequest obj);

    public BookResponse toResponse(Book obj);
}
