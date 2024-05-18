package com.elcaserio.service;

import com.elcaserio.model.DireccionCliente;
import com.elcaserio.repository.IDireccionClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionClienteService implements IDireccionClienteService {

    @Autowired
    IDireccionClienteRepository iDireccionClienteRepo;

    @Override
    public void agregarDireccion(DireccionCliente direccionCliente) {
        iDireccionClienteRepo.save(direccionCliente);
    }

    @Override
    public List<DireccionCliente> verDirecciones() {
        return iDireccionClienteRepo.findAll();
    }

    @Override
    public DireccionCliente buscarDireccion(Long id) {
        return iDireccionClienteRepo.findById(id).orElse(null);
    }

    @Override
    public void eliminarDireccion(Long id) {
        iDireccionClienteRepo.deleteById(id);
    }

    @Override
    public void eliminarDirecciones() {
        iDireccionClienteRepo.deleteAll();
    }

    @Override
    public void modificarDireccion(DireccionCliente direccionCliente) {
        iDireccionClienteRepo.save(direccionCliente);
    }
}
