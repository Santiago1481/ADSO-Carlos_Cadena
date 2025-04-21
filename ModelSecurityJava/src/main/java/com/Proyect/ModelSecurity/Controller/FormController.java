package com.Proyect.ModelSecurity.Controller;

import com.Proyect.ModelSecurity.Service.FormService;
import com.Proyect.ModelSecurity.model.Form;
import com.Proyect.ModelSecurity.DTO.FormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/forms")
public class FormController {

    @Autowired
    private FormService formService;

    // Obtener todos los formularios
    @GetMapping("/")
    public ResponseEntity<List<FormDTO>> findAllForms() {
        List<FormDTO> formList = formService.findAllForms();
        return new ResponseEntity<>(formList, HttpStatus.OK);
    }

    // Obtener formulario por ID
    @GetMapping("/{id}")
    public ResponseEntity<FormDTO> findByIdForm(@PathVariable int id) {
        return formService.findByIdForm(id)
                .map(formDTO -> new ResponseEntity<>(formDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear nuevo formulario
    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Form form) {
        formService.save(form);
        return new ResponseEntity<>("Form created successfully", HttpStatus.CREATED);
    }

    // Actualizar formulario
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Form form) {
        formService.update(id, form);
        return new ResponseEntity<>("Form updated successfully", HttpStatus.OK);
    }

    // Eliminar formulario
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        formService.delete(id);
        return new ResponseEntity<>("Form deleted successfully", HttpStatus.OK);
    }
}
