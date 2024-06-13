package com.elcaserio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
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
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime fechaHora;

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