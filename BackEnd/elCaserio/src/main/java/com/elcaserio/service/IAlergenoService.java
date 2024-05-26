package com.elcaserio.service;

import com.elcaserio.model.Alergeno;

import java.util.List;

public interface IAlergenoService {

    public void crearAlergeno(Alergeno alergeno);

    public void eliminarAlergeno(Long id);

    public void eliminarTodo();

    public List<Alergeno> verAlergenos();

    public Alergeno buscarAlergeno(Long id);

    public void modificarAlergeno(Alergeno alergeno);

}
