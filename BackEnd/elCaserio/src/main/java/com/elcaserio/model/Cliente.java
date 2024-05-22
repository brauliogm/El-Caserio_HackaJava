package com.elcaserio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    @OneToOne
    private DireccionCliente direccionCliente;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String apellido, String telefono, String email, DireccionCliente direccionCliente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccionCliente = direccionCliente;
    }

}
