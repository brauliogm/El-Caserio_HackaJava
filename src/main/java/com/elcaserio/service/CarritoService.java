package com.elcaserio.service;

import com.elcaserio.model.Carrito;
import com.elcaserio.repository.ICarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService implements ICarritoService {

    @Autowired
    ICarritoRepository iCarritoRepo;

    //MÉTODO PARA CREAR UN NUEVO CARRITO
    @Override
    public void crearCarrito(Carrito carrito) {
        iCarritoRepo.save(carrito);
    }

    @Override
    public List<Carrito> verCarrito() {
        return iCarritoRepo.findAll();
    }

    @Override
    public void vaciarCarrito() {
        iCarritoRepo.deleteAll();
    }
}
