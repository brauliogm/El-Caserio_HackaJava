package com.elcaserio.service;

import com.elcaserio.exepcion.RecursoNoEncontradoExcepcion;
import com.elcaserio.model.Carrito;
import com.elcaserio.repository.ICarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoService implements ICarritoService {

    @Autowired
    ICarritoRepository iCarritoRepo;

    //MÉTODO PARA CREAR UN NUEVO CARRITO
    @Override
    public void crearCarrito(Carrito carrito) {
        iCarritoRepo.save(carrito);
    }

    //MÉTODO PARA BUSCAR UN CARRITO
    @Override
    public Carrito verCarrito(Long idCarrito) {
        return iCarritoRepo.findById(idCarrito).orElse(null);
    }

    //MÉTODO PARA BORRAR UN CARRITO
    @Override
    public void vaciarCarrito(Long idCarrito) {
        iCarritoRepo.deleteById(idCarrito);
    }

    //METODO PARA MODIFICAR LOS PRODUCTOS DEL CARRITO
    @Override
    public Carrito modificarProductos(Carrito carritoRecibido, Long id) {
        Carrito carrito = this.verCarrito(id);
        if (carrito == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        carrito.setProductos(carritoRecibido.getProductos());
        carrito.setTotalDelCarrito(carritoRecibido.getTotalDelCarrito());

        iCarritoRepo.save(carrito);
        return carrito;
    }


}
