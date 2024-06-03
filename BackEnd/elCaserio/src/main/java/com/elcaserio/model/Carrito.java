package com.elcaserio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter @Setter
@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToMany
    private List<Producto> productos;
    @ManyToOne
    private Cliente cliente;
    private double totalDelCarrito;

    public Carrito() {
    }

    public Carrito(Long id, List<Producto> productos, double totalDelCarrito) {
        this.id = id;
        this.productos = productos;
        this.totalDelCarrito = totalDelCarrito;
    }

    public Carrito(Long id, List<Producto> productos, Cliente cliente, double totalDelCarrito) {
        this.id = id;
        this.productos = productos;
        this.cliente = cliente;
        this.totalDelCarrito = totalDelCarrito;
    }
}