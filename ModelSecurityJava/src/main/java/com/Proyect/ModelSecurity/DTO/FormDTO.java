package com.Proyect.ModelSecurity.DTO;

import java.time.LocalDateTime;

public class FormDTO {

    private int idForm;
    private String nameForm;
    private String descriptionForm;
    private LocalDateTime createDate;
    private int active;

    // Constructor vacío
    public FormDTO() {}

    // Constructor con parámetros
    public FormDTO(int idForm, String nameForm, String descriptionForm, LocalDateTime createDate, int active) {
        this.idForm = idForm;
        this.nameForm = nameForm;
        this.descriptionForm = descriptionForm;
        this.createDate = createDate;
        this.active = active;
    }

    // Getters y Setters
    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public String getNameForm() {
        return nameForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    public String getDescriptionForm() {
        return descriptionForm;
    }

    public void setDescriptionForm(String descriptionForm) {
        this.descriptionForm = descriptionForm;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
