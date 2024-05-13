package com.elcaserio.service;

import com.elcaserio.model.DireccionCliente;

import java.util.List;

public interface IDireccionClienteService {

    public void agregarDireccion(DireccionCliente direccionCliente);

    public List<DireccionCliente> verDirecciones();

    public DireccionCliente buscarDireccion(Long id);

    public void eliminarDireccion(Long id);

    public void eliminarDirecciones();

    public void modificarDireccion(DireccionCliente direccionCliente);

}
