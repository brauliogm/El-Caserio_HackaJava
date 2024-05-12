package com.elcaserio.service;

import com.elcaserio.model.Cliente;

import java.util.List;

public interface IClienteService {

    public void crearCliente(Cliente cliente);

    public List<Cliente> verClientes();

    public Cliente buscarCliente(Long id);

    public void eliminarCliente(Long id);

    public void eliminarTodo();

    public void modificarCliente(Long id, String nombreNuevo, String telefonoNuevo, String emailNuevo, String direccionNueva);

}
