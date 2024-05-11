package com.elcaserio.controller;

import com.elcaserio.model.Alergeno;
import com.elcaserio.service.IAlergenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @PutMapping("/modificarAlergeno/{idAntiguo}")
    public String modificarAlergeno(@PathVariable int idAntiguo,
                                    @RequestParam(required = false, name = "id") int idNueva,
                                    @RequestParam(required = false, name = "nombre") String nombreNuevo) {

        iAlergenoService.modificarAlergeno(idAntiguo, idNueva, nombreNuevo);
        return "Alergeno modificado correctamente.";
    }

}
