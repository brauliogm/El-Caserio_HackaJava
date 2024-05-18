package com.elcaserio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Alergeno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nombre;

    public Alergeno() {
    }

    public Alergeno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alergeno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
