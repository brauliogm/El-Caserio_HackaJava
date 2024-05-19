package com.elcaserio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String categoria;
    private String subcategoria;
    private String descripcion;
    @ManyToMany
    private List<Alergeno> listaAlergenos;
    private double precio;

    public Producto() {
    }

    public Producto(Long id, String nombre, String categoria, String subcategoria, String descripcion, List<Alergeno> listaAlergenos, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.listaAlergenos = listaAlergenos;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

}