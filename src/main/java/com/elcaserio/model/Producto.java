package com.elcaserio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Producto {

    private Long id;
    private String nombre;
    private String categoria;
    private String subcategoria;
    private String descripcion;
    private Alergeno alergenos;
    private double precio;

    public Producto(Long id, String nombre, String categoria, String subcategoria, String descripcion, Alergeno alergenos, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.descripcion = descripcion;
        this.alergenos = alergenos;
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
