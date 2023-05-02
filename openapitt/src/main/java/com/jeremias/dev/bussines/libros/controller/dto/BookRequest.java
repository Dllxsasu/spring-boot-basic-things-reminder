package com.jeremias.dev.bussines.libros.controller.dto;

import com.jeremias.dev.bussines.libros.validations.TitleValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
@Schema(description = "Book request")
@Getter
@Setter
@ToString
@Builder
public class BookRequest {

    @TitleValidation
    @Schema(description = "The title of the book",example = "Harry poter", required = true, format = "unique")
    @NotBlank(message = "the title is required")
    private String title;
    @Schema(description = "The author of the book",example = "pedro picapiedra poter",  required = true)
    @NotBlank(message = "the autor is required")
    private String author;

}
