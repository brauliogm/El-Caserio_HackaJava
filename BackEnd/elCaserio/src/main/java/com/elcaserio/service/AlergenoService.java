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
    public void eliminarAlergeno(Long id) {
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
        return alergenoRepo.findAll();
    }

    // MÉTODO PARA BUSCAR UNO SOLO
    @Override
    public Alergeno buscarAlergeno(Long id) {
        return alergenoRepo.findById(id).orElse(null);
    }

    // MÉTODO PARA MODIFICARLO
    @Override
    public void modificarAlergeno(Alergeno alergeno) {
        alergenoRepo.save(alergeno);
    }
}
