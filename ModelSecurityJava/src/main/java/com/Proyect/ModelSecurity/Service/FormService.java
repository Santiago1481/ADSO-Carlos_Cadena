package com.Proyect.ModelSecurity.Service;

import com.Proyect.ModelSecurity.DTO.FormDTO;
import com.Proyect.ModelSecurity.model.Form;
import com.Proyect.ModelSecurity.interfaces.IForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormService {

    @Autowired
    private IForm formData;

    // Obtener todos los formularios
    public List<FormDTO> findAllForms() {
        List<Form> forms = formData.findAll();
        return forms.stream()
                    .map(form -> new FormDTO(form.getIdForm(), form.getNameForm(), form.getDescriptionForm(), form.getCreateDate(), form.getActive()))
                    .collect(Collectors.toList());
    }

    // Buscar un formulario por ID
    public Optional<FormDTO> findByIdForm(int id) {
        Optional<Form> form = formData.findById(id);
        return form.map(f -> new FormDTO(f.getIdForm(), f.getNameForm(), f.getDescriptionForm(), f.getCreateDate(), f.getActive()));
    }

    // Guardar un nuevo formulario
    public void save(Form form) {
        formData.save(form);
    }

    // Actualizar un formulario
    public void update(int id, Form updatedForm) {
        var form = formData.findById(id);
        if (form.isPresent()) {
            Form existingForm = form.get();
            existingForm.setNameForm(updatedForm.getNameForm());
            existingForm.setDescriptionForm(updatedForm.getDescriptionForm());
            existingForm.setCreateDate(updatedForm.getCreateDate());
            existingForm.setActive(updatedForm.getActive());
            formData.save(existingForm);
        }
    }

    // Eliminar un formulario
    public void delete(int id) {
        var form = formData.findById(id);
        form.ifPresent(formData::delete);
    }
}
