package com.elcaserio.service;

import com.elcaserio.model.Carrito;
import com.elcaserio.model.Producto;

import java.util.List;

public interface ICarritoService {

    public List<Carrito> verCarritos();

    public void crearCarrito(Carrito carrito);

    public Carrito verCarrito(Long idCarrito);

    public void vaciarCarrito(Long idCarrito);

    public Carrito modificarProductos(Carrito carritoRecibido, Long id);

}
