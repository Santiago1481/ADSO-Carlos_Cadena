package com.Proyect.ModelSecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "RolFormPermission")
public class RolFormPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", length = 15)
    private int id;

    @ManyToOne
    @JoinColumn(name = "IdRol")
    private Rol rol;  // Asegúrate de tener la entidad Rol en tu proyecto

    @ManyToOne
    @JoinColumn(name = "IdForm")
    private Form form;  // Asegúrate de tener la entidad Form en tu proyecto

    @ManyToOne
    @JoinColumn(name = "IdPermission")
    private Permission permission;  // Asegúrate de tener la entidad Permission en tu proyecto

    // Constructor vacío
    public RolFormPermission() {}

    // Constructor con parámetros
    public RolFormPermission(Rol Rol, Form form, Permission permission) {
        this.rol = Rol;
        this.form = form;
        this.permission = permission;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol Rol) {
        this.rol = Rol;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
