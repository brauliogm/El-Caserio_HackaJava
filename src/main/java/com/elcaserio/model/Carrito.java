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
    @ManyToOne
    private Cliente cliente;

    public Carrito() {
    }

    public Carrito(Long id, List<Producto> listaProductos) {
        this.id = id;
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", listaProductos=" + listaProductos +
                '}';
    }
}