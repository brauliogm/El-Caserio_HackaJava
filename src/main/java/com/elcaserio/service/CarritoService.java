package com.elcaserio.service;

import com.elcaserio.model.Carrito;
import com.elcaserio.model.Producto;
import com.elcaserio.repository.ICarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService implements ICarritoService {

    @Autowired
    ICarritoRepository iCarritoRepo;

    Producto producto;

    Carrito carrito;

    @Override
    public void agregarProductoCarrito(Producto producto) {
        carrito.setTotalCarrito(producto.getPrecio());
        iCarritoRepo.save(producto);
    }

    @Override
    public List<Carrito> verCarrito() {
        return iCarritoRepo.findAll();
    }

    @Override
    public void eliminarProductoCarrito(Long id) {
        iCarritoRepo.deleteById(id);
    }

    @Override
    public void vaciarCarrito() {
        iCarritoRepo.deleteAll();
    }
}
