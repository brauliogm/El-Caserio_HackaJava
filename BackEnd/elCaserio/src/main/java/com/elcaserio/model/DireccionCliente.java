package com.elcaserio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class DireccionCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String calle;
    private int codigoPostal;
    private String localidad;
    private String provincia;

    public DireccionCliente() {
    }

    public DireccionCliente(Long id, String calle, int codigoPostal, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "DireccionCliente{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
