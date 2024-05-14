package com.elcaserio.service;

import com.elcaserio.model.Carrito;
import com.elcaserio.model.Producto;

import java.util.List;

public interface ICarritoService {

    public void agregarProductoCarrito(Producto producto);

    public List<Carrito> verCarrito();

    public void eliminarProductoCarrito(Long id);

    public void vaciarCarrito();

}
