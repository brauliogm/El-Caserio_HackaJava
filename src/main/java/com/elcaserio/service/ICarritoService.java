package com.elcaserio.service;

import com.elcaserio.model.Carrito;

import java.util.List;

public interface ICarritoService {

    public void crearCarrito(Carrito carrito);

    public List<Carrito> verCarrito();

    public void vaciarCarrito();

}
