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
    private List<Producto> productos;
    @ManyToOne
    private Cliente cliente;

    public Carrito() {
    }

    public Carrito(Long id, List<Producto> productos, Cliente cliente) {
        this.id = id;
        this.productos = productos;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", productos=" + productos +
                ", cliente=" + cliente;
    }
}