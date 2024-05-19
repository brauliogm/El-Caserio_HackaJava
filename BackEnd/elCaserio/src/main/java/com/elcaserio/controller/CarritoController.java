package com.elcaserio.controller;

import com.elcaserio.model.Carrito;
import com.elcaserio.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(value = "http://localhost:4200")
public class CarritoController {

    @Autowired
    ICarritoService iCarritoService;

    @GetMapping("/verCarrito/{id}")
    public Carrito verCarrito(@PathVariable Long idCarrito) {
        return iCarritoService.verCarrito(idCarrito);
    }

    @PostMapping("/crearCarrito")
    public Carrito crearCarrito(@RequestBody Carrito carrito) {
        iCarritoService.crearCarrito(carrito);
        return carrito;
    }

    @DeleteMapping("/vaciarCarrito/{id}")
    public String vaciarCarrito(@PathVariable Long idCarrito) {
        iCarritoService.vaciarCarrito(idCarrito);
        return "Carrito eliminado correctamente.";
    }

}