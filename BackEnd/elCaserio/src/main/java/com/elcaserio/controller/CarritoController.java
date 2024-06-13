package com.elcaserio.controller;

import com.elcaserio.exepcion.RecursoNoEncontradoExcepcion;
import com.elcaserio.model.Carrito;
import com.elcaserio.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("el-caserio/carrito")
@CrossOrigin(value = "http://localhost:4200")
public class CarritoController {

    @Autowired
    ICarritoService iCarritoService;

    @GetMapping()
    public List<Carrito> verCarritos() {
        return iCarritoService.verCarritos();
    }

    @GetMapping("/{id}")
    public Carrito verCarritoPorId(@PathVariable Long id) {
        return iCarritoService.verCarrito(id);
    }

    @PostMapping()
    public Carrito crearCarrito(@RequestBody Carrito carrito) {
        iCarritoService.crearCarrito(carrito);
        return carrito;
    }

    @PutMapping("/{id}")
    public Carrito modificarListaDelCarrito(@RequestBody Carrito carrito, @PathVariable Long id) {
        return iCarritoService.modificarProductos(carrito, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCarritoPorId(@PathVariable Long id) {
        Carrito carrito = this.verCarritoPorId(id);
        if (carrito == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        iCarritoService.vaciarCarrito(carrito.getId());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Carrito eliminado correctamente", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
