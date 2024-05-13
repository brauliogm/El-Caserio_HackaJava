package com.elcaserio.controller;

import com.elcaserio.model.Cliente;
import com.elcaserio.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/verClientes")
    public List<Cliente> verClientes() {
        return iClienteService.verClientes();
    }

    @GetMapping("/buscarCliente/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return iClienteService.buscarCliente(id);
    }

    @PostMapping("/crearCliente")
    public String crearCliente(@RequestBody Cliente cliente) {
        iClienteService.crearCliente(cliente);
        return "Cliente creado correctamente.";
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        iClienteService.eliminarCliente(id);
        return "Cliente eliminado correctamente";
    }

    @DeleteMapping("/eliminarClientes")
    public String eliminarClientes() {
        iClienteService.eliminarClientes();
        return "Se han eliminado todos los clientes de la base de datos correctamente.";
    }

    @PutMapping("/modificarCliente/{id}")
    public String modificarCliente(@PathVariable Long id,
                                   @RequestParam (required = false, name = "nombre") String nombreNuevo,
                                   @RequestParam (required = false, name = "telefono") String telefonoNuevo,
                                   @RequestParam (required = false, name = "email") String emailNuevo,
                                   @RequestParam (required = false, name = "direccion") String direccionNueva) {
        iClienteService.modificarCliente(id, nombreNuevo, telefonoNuevo, emailNuevo, direccionNueva);

        return "Cliente modificado correctamente.";
    }

}
