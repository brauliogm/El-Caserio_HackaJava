package com.elcaserio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    @OneToOne
    private DireccionCliente direccionCliente;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String telefono, String email, DireccionCliente direccionCliente) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccionCliente = direccionCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccionCliente=" + direccionCliente +
                '}';
    }

}
