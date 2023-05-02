package com.jeremias.dev.bussines.libros.controller.dto;

import com.jeremias.dev.bussines.libros.validations.TitleValidation;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
@Schema(description = "Book")
public class BookResponse {
    @Schema(description = "id of book",example = "1", format = "number")
    private long id;

    @Schema(description = "The title of the book",example = "Harry poter")
    private String title;
    @Schema(description = "The author of the book",example = "pedro picapiedra poter")
    private String author;
}
