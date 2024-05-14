package com.elcaserio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToMany
    private List<Producto> listaProductos;
    private double totalCarrito;

    public Carrito() {
    }

    public Carrito(Long id, List<Producto> listaProductos, double totalCarrito) {
        this.id = id;
        this.listaProductos = listaProductos;
        this.totalCarrito = totalCarrito;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", listaProductos=" + listaProductos +
                ", totalCarrito=" + totalCarrito +
                '}';
    }
}
