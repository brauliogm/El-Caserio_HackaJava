package com.elcaserio.service;

import com.elcaserio.model.Producto;
import com.elcaserio.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    IProductoRepository iProductoRepo;

    //MÉTODO PARA VER TODOS LOS PRODUCTOS
    @Override
    public List<Producto> verProductos() {
        List<Producto> listaProductos = iProductoRepo.findAll();
        return listaProductos;
    }

    //MÉTODO PARA VER UN SOLO PRODUCTO
    @Override
    public Producto verProducto(Long id) {
        Producto producto = iProductoRepo.findById(id).orElse(null);
        return producto;
    }

    //MÉTODO PARA CREAR UN PRODUCTO
    @Override
    public void crearProducto(Producto producto) {
        iProductoRepo.save(producto);
    }

    //MÉTODO PARA ELIMINAR UN PRODUCTO
    @Override
    public void eliminarProducto(Long id) {
        iProductoRepo.deleteById(id);
    }

    //MÉTODO PARA ELIMINAR TODOS LOS PRODUCTOS
    @Override
    public void eliminarProductos() {
        iProductoRepo.deleteAll();
    }

    //MÉTODO PARA MODIFICAR UN PRODUCTO
    @Override
    public void modificarProducto(Producto producto) {
        iProductoRepo.save(producto);
    }
}
