package com.elcaserio.controller;

import com.elcaserio.model.Alergeno;
import com.elcaserio.service.IAlergenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(value = "http://localhost:4200")
public class AlergenoController {

    @Autowired
    private IAlergenoService iAlergenoService;

    @GetMapping("/verAlergenos")
    public List<Alergeno> verAlergenos() {
        return iAlergenoService.verAlergenos();
    }

    @PostMapping("/crearAlergeno")
    public String crearAlergeno(@RequestBody Alergeno alergeno) {
        iAlergenoService.crearAlergeno(alergeno);
        return "Alergeno creado correctamente";
    }

    @DeleteMapping("/eliminarAlergeno/{id}")
    public String eliminarAlergeno(@PathVariable int id) {
        iAlergenoService.eliminarAlergeno(id);
        return "Alergeno eliminado correctamente";
    }

    @DeleteMapping("/eliminarAlergenos")
    public String eliminarTodo() {
        iAlergenoService.eliminarTodo();
        return "Se han eliminado todos los Alérgenos de la base de datos correctamente.";
    }

    @PutMapping("/modificarAlergeno")
    public String modificarAlergeno(@RequestBody Alergeno alergeno) {
        iAlergenoService.modificarAlergeno(alergeno);

        return "Alergeno modificado correctamente.";
    }

}
