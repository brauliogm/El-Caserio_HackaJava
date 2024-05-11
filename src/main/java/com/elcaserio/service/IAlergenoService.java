package com.elcaserio.service;

import com.elcaserio.model.Alergeno;

import java.util.List;

public interface IAlergenoService {

    public void crearAlergeno(Alergeno alergeno);

    public void eliminarAlergeno(int id);

    public List<Alergeno> verAlergenos();

    public Alergeno buscarAlergeno(int id);

    public void modificarAlergeno(int idAntiguo, int idNuevo, String nombreNuevo);

}
