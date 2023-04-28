package com.example.paging;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "character")
public class MovieCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String movie;
}
