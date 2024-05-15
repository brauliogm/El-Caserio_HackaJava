package com.elcaserio.controller;

import com.elcaserio.model.Carrito;
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

    @PostMapping("/crearCarrito")
    public Carrito crearCarrito(@RequestBody Carrito carrito) {
        iCarritoService.crearCarrito(carrito);
        return carrito;
    }

    @DeleteMapping("/vaciarCarrito")
    public String vaciarCarrito() {
        iCarritoService.vaciarCarrito();
        return "Carrito vaciado correctamente.";
    }

}
