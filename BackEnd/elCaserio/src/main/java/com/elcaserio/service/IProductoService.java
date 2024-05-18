package com.elcaserio.service;

import com.elcaserio.model.Alergeno;
import com.elcaserio.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> verProductos();

    public Producto verProducto(Long id);

    public void crearProducto(Producto producto);

    public void eliminarProducto(Long id);

    public void eliminarProductos();

    // public void modificarProducto(Long id, String nombreNuevo, String categoriaNueva, String subcategoriaNueva, String descripcionNueva, List<Alergeno> alergenosNuevos, double precioNuevo);

    public void modificarProducto(Producto producto);

}
