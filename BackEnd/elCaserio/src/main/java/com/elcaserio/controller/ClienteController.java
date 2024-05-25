package com.elcaserio.controller;

import com.elcaserio.model.Carrito;
import com.elcaserio.model.Cliente;
import com.elcaserio.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("el-caserio/cliente")
@CrossOrigin(value = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping()
    public List<Cliente> verClientes() {
        return iClienteService.verClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return iClienteService.buscarCliente(id);
    }

    @PostMapping("/crearCliente")
    public String crearCliente(@RequestBody Cliente cliente) {
        iClienteService.crearCliente(cliente);
        return "Cliente creado correctamente.";
    }

    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        iClienteService.eliminarCliente(id);
        return "Cliente eliminado correctamente";
    }

    @DeleteMapping()
    public String eliminarClientes() {
        iClienteService.eliminarClientes();
        return "Se han eliminado todos los clientes de la base de datos correctamente.";
    }

    @PutMapping("/{id}")
    public String modificarCliente(@RequestBody Cliente cliente) {
        iClienteService.modificarCliente(cliente);

        return "Cliente modificado correctamente.";
    }

}
