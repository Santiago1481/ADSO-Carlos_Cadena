package com.Proyect.ModelSecurity.model;

import jakarta.persistence.*;

@Entity(name = "ModuleForm")
public class ModuleForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdModuleForm")
    private Long idModuleForm;

    @ManyToOne
    @JoinColumn(name = "IdModule", nullable = false)
    private Module module;

    @ManyToOne
    @JoinColumn(name = "IdForm", nullable = false)
    private Form form;

    @Column(name = "active")
    private Boolean deleted = false;

    public ModuleForm() {
    }

    public ModuleForm(Long idModuleForm, Module module, Form form, Boolean deleted) {
        this.idModuleForm = idModuleForm;
        this.module = module;
        this.form = form;
        this.deleted = deleted;
    }

    public Long getIdModuleForm() {
        return idModuleForm;
    }

    public void setIdModuleForm(Long idModuleForm) {
        this.idModuleForm = idModuleForm;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
