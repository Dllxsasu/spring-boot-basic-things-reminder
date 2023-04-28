package com.example.paging;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String nombre;
    @Column(nullable = false)
    String apellido;
    @Builder
    public Cliente(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
