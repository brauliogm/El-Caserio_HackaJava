package com.elcaserio.controller;

import com.elcaserio.model.Producto;
import com.elcaserio.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("el-caserio/producto")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoController {

    @Autowired
    IProductoService iProductoService;

    @GetMapping()
    public List<Producto> verProductos() {
        return iProductoService.verProductos();
    }

    @GetMapping("/{id}")
    public Producto verProducto(@PathVariable Long id) {
        return iProductoService.verProducto(id);
    }

    @PostMapping()
    public String crearProducto(@RequestBody Producto producto) {
        iProductoService.crearProducto(producto);
        return "Producto creado correctamente.";
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        iProductoService.eliminarProducto(id);
        return "Producto eliminado correctamente.";
    }

    @DeleteMapping()
    public String eliminarProductos() {
        iProductoService.eliminarProductos();
        return "Todos los productos han sido eliminados correctamente.";
    }

    @PutMapping("/{id}")
    public String modificarProducto(@RequestBody Producto producto) {
        iProductoService.modificarProducto(producto);

        return "Producto modificado correctamente.";
    }

}
