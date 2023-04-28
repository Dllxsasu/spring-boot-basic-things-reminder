package com.example.paging.producto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    double precio;
    @Column(nullable = false)
    int stock;
    @Column(nullable = false)
    String nombre;

    @Builder
    public Producto(int id, double precio, int stock, String nombre) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.nombre = nombre;
    }

    public Producto() {

    }
}
