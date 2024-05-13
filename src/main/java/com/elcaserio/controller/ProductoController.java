package com.elcaserio.controller;

import com.elcaserio.model.Alergeno;
import com.elcaserio.model.Producto;
import com.elcaserio.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    IProductoService iProductoService;

    @GetMapping("/verProductos")
    public List<Producto> verProductos() {
        return iProductoService.verProductos();
    }

    @GetMapping("/verProducto/{id}")
    public Producto verProducto(@PathVariable Long id) {
        return iProductoService.verProducto(id);
    }

    @PostMapping("/crearProducto")
    public String crearProducto(@RequestBody Producto producto) {
        iProductoService.crearProducto(producto);
        return "Producto creado correctamente.";
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        iProductoService.eliminarProducto(id);
        return "Producto eliminado correctamente.";
    }

    @DeleteMapping("/eliminarProductos")
    public String eliminarProductos() {
        iProductoService.eliminarProductos();
        return "Todos los productos han sido eliminados correctamente.";
    }

    @PutMapping("/modificarProducto/{id}")
    public String modificarProducto(@PathVariable Long id,
                                    @RequestParam(required = false, name = "nombre") String nombreNuevo,
                                    @RequestParam(required = false, name = "categoria") String categoriaNueva,
                                    @RequestParam(required = false, name = "subcategoria") String subcategoriaNueva,
                                    @RequestParam(required = false, name = "descripcion") String descripcionNueva,
                                    @RequestParam(required = false, name = "alergenos") List<Alergeno> alergenosNuevos,
                                    @RequestParam(required = false, name = "precio") double precioNuevo) {
        iProductoService.modificarProducto(id, nombreNuevo, categoriaNueva, subcategoriaNueva, descripcionNueva, alergenosNuevos, precioNuevo);

        return "Producto modificado correctamente.";
    }

}
