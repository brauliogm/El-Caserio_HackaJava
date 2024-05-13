package com.elcaserio.controller;

import com.elcaserio.model.DireccionCliente;
import com.elcaserio.service.IDireccionClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DireccionClienteController {

    @Autowired
    IDireccionClienteService iDireccionClienteService;

    @GetMapping("/verDirecciones")
    public List<DireccionCliente> verDirecciones() {
        return iDireccionClienteService.verDirecciones();
    }

    @GetMapping("/verDirecciones/{id}")
    public DireccionCliente buscarDireccion(@PathVariable Long id) {
        return iDireccionClienteService.buscarDireccion(id);
    }

    @PostMapping("/agregarDireccion")
    public String agregarDireccion(@RequestBody DireccionCliente direccionCliente) {
        iDireccionClienteService.agregarDireccion(direccionCliente);
        return "Dirección agregada correctamente";
    }

    @DeleteMapping("/eliminarDireccion{id}")
    public String eliminarDireccion(@PathVariable Long id) {
        iDireccionClienteService.eliminarDireccion(id);
        return "Dirección eliminada correctamente.";
    }

    @DeleteMapping("/eliminarDirecciones")
    public String eliminarDirecciones() {
        iDireccionClienteService.eliminarDirecciones();
        return "Se han eliminado todas las direcciones correctamente.";
    }

    @PutMapping("/modificarDireccion")
    public String modificarDireccion(@RequestBody DireccionCliente direccionCliente) {
        iDireccionClienteService.modificarDireccion(direccionCliente);
        return "Dirección modificada correctamente.";
    }

}
