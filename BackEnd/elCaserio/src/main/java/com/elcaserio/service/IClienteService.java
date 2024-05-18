package com.elcaserio.service;

import com.elcaserio.model.Carrito;
import com.elcaserio.model.Cliente;
import com.elcaserio.model.Producto;

import java.util.List;

public interface IClienteService {

    public void crearCliente(Cliente cliente);

    public List<Cliente> verClientes();

    public Cliente buscarCliente(Long id);

    public void eliminarCliente(Long id);

    public void eliminarClientes();

    public void modificarCliente(Cliente cliente);

}
