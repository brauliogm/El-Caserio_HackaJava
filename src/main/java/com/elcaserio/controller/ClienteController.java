package com.elcaserio.controller;

import com.elcaserio.model.Cliente;
import com.elcaserio.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return "Cliente creado correctamente.";
    }

    @DeleteMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        iClienteService.eliminarCliente(id);
        return "Cliente eliminado correctamente";
    }

    @PutMapping("/modificarCliente/{id}")
    public String modificarCliente(@PathVariable Long id,
                                   @RequestParam (required = false) String nombreNuevo,
                                   @RequestParam (required = false) String telefonoNuevo,
                                   @RequestParam (required = false) String emailNuevo,
                                   @RequestParam (required = false) String direccionNueva) {
        iClienteService.modificarCliente(id, nombreNuevo, telefonoNuevo, emailNuevo, direccionNueva);

        return "Cliente modificado correctamente.";
    }

}
