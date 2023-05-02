package com.jeremias.dev.bussines.libros.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "title is mandatory")
    private String title;
    @NotBlank(message = "name author is mandatory")
    private String author;

}

