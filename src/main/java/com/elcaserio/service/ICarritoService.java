package com.elcaserio.service;

import com.elcaserio.model.Carrito;

public interface ICarritoService {

    public void crearCarrito(Carrito carrito);

    public Carrito verCarrito(Long idCarrito);

    public void vaciarCarrito(Long idCarrito);

}
