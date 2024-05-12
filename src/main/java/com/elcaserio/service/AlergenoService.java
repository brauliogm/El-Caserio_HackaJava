package com.elcaserio.service;

import com.elcaserio.model.Alergeno;
import com.elcaserio.repository.IAlergenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlergenoService implements IAlergenoService {

    @Autowired
    private IAlergenoRepository alergenoRepo;

    // MÉTODO PARA CREAR
    @Override
    public void crearAlergeno(Alergeno alergeno) {
        alergenoRepo.save(alergeno);
    }

    // MÉTODO PARA ELIMINAR
    @Override
    public void eliminarAlergeno(int id) {
        alergenoRepo.deleteById(id);
    }

    // MÉTODO PARA ELIMINAR TODOS LOS ALERGENOS
    @Override
    public void eliminarTodo() {
        alergenoRepo.deleteAll();
    }

    //MÉTODO PARA VER LA LISTA COMPLETA
    @Override
    public List<Alergeno> verAlergenos() {
        List<Alergeno> listaAlergenos = alergenoRepo.findAll();
        return listaAlergenos;
    }

    // MÉTODO PARA BUSCAR UNO SOLO
    @Override
    public Alergeno buscarAlergeno(int id) {
        Alergeno alergeno = alergenoRepo.findById(id).orElse(null);
        return alergeno;
    }

    // MÉTODO PARA MODIFICARLO
    @Override
    public void modificarAlergeno(int idAntiguo, int idNuevo, String nombreNuevo) {
        Alergeno alergeno = buscarAlergeno(idAntiguo);
        alergeno.setId(idNuevo);
        alergeno.setNombre(nombreNuevo);
        alergenoRepo.save(alergeno);
    }
}
