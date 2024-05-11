package com.elcaserio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Alergeno {

    private int id;
    private String nombre;

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
