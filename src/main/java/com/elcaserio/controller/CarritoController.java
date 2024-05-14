package com.elcaserio.controller;

import com.elcaserio.model.Carrito;
import com.elcaserio.model.Producto;
import com.elcaserio.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarritoController {

    @Autowired
    ICarritoService iCarritoService;

    @GetMapping("/verCarrito")
    public List<Carrito> verCarrito() {
        return iCarritoService.verCarrito();
    }

    @PostMapping("/agregarProductoCarrito")
    public String agregarProducto(@RequestBody Producto producto) {
        iCarritoService.agregarProductoCarrito(producto);
        return "Producto agregado al carrito correctamente";
    }

    @DeleteMapping("/eliminarProductoCarrito/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        iCarritoService.eliminarProductoCarrito(id);
        return "Producto eliminado del carrito correctamente.";
    }

    @DeleteMapping("/vaciarCarrito")
    public String vaciarCarrito() {
        iCarritoService.vaciarCarrito();
        return "Carrito vaciado correctamente.";
    }

}
