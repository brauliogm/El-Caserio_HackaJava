package com.elcaserio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cliente {

    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private DireccionCliente direccion;

    public Cliente(Long id, String nombre, String telefono, String email, DireccionCliente direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion=" + direccion +
                '}';
    }

}
