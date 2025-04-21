package com.Proyect.ModelSecurity.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity(name = "Form")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdForm", length = 15)
    private int idForm;

    @Column(name = "nameForm", length = 50)
    private String nameForm;

    @Column(name = "descriptionForm", length = 50)
    private String descriptionForm;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Column(name = "active", length = 5)
    private int active;

    // Constructor vacío
    public Form() {}

    // Constructor con parámetros
    public Form(int idForm, String nameForm, String descriptionForm, LocalDateTime createDate, int active) {
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

        @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
        private Set<RolFormPermission> rolFormPermissions;
}
