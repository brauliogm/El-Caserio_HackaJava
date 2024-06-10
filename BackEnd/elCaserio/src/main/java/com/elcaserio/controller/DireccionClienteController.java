package com.elcaserio.controller;

import com.elcaserio.model.DireccionCliente;
import com.elcaserio.service.IDireccionClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("el-caserio/direccion-cliente")
@CrossOrigin(value = "http://localhost:4200")
public class DireccionClienteController {

    @Autowired
    IDireccionClienteService iDireccionClienteService;

    @GetMapping()
    public List<DireccionCliente> verDirecciones() {
        return iDireccionClienteService.verDirecciones();
    }

    @GetMapping("/{id}")
    public DireccionCliente buscarDireccion(@PathVariable Long id) {
        return iDireccionClienteService.buscarDireccion(id);
    }

    @PostMapping()
    public DireccionCliente agregarDireccion(@RequestBody DireccionCliente direccionCliente) {
        iDireccionClienteService.agregarDireccion(direccionCliente);
        return direccionCliente;
    }

    @DeleteMapping("/{id}")
    public String eliminarDireccion(@PathVariable Long id) {
        iDireccionClienteService.eliminarDireccion(id);
        return "Dirección eliminada correctamente.";
    }

    @DeleteMapping()
    public String eliminarDirecciones() {
        iDireccionClienteService.eliminarDirecciones();
        return "Se han eliminado todas las direcciones correctamente.";
    }

    @PutMapping("/{id}")
    public String modificarDireccion(@RequestBody DireccionCliente direccionCliente) {
        iDireccionClienteService.modificarDireccion(direccionCliente);
        return "Dirección modificada correctamente.";
    }

}
