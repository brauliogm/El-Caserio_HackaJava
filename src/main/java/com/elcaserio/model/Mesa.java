package com.elcaserio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Mesa {

    private Long id;
    private int numero;
    private int capacidad;
    private EstadoMesa estado;

    public Mesa(Long id, int numero, int capacidad) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = EstadoMesa.DISPONIBLE;
    }

    // Método para reservar la mesa
    public void reservar() {
        estado = EstadoMesa.RESERVADA;
    }

    // Método para liberar la mesa
    public void liberar() {
        estado = EstadoMesa.DISPONIBLE;
    }

    // Método para marcar la mesa como ocupada
    public void ocupar() {
        estado = EstadoMesa.OCUPADA;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "id=" + id +
                ", numero=" + numero +
                ", capacidad=" + capacidad +
                ", estado=" + estado +
                '}';
    }

    // Enumeración para representar el estado de la mesa
    public enum EstadoMesa {
        DISPONIBLE,
        OCUPADA,
        RESERVADA
    }

}
