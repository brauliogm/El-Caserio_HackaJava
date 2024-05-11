package com.elcaserio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DireccionCliente {

    private Long id;
    private String calle;
    private int codigoPostal;
    private String localidad;
    private String provincia;
    private String pais;

    public DireccionCliente(Long id, String calle, int codigoPostal, String localidad, String provincia, String pais) {
        this.id = id;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

}
