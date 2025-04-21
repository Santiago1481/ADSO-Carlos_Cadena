package com.Proyect.ModelSecurity.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdModule", length = 10)
    public int IdModule;

    @Column(name = "nameModule", length = 50 )
    public String nameModuele;

    @Column(name = "descriptionModule", length = 200)
    public String descriptionModule;

    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Column(name = "active", length = 5)
    private int active;

    public Module() {
    }

    public Module(int idModule, String nameModuele, String descriptionModule, LocalDateTime createDate, int active) {
        IdModule = idModule;
        this.nameModuele = nameModuele;
        this.descriptionModule = descriptionModule;
        this.createDate = createDate;
        this.active = active;
    }

    public int getIdModule() {
        return IdModule;
    }

    public void setIdModule(int idModule) {
        IdModule = idModule;
    }

    public String getNameModuele() {
        return nameModuele;
    }

    public void setNameModuele(String nameModuele) {
        this.nameModuele = nameModuele;
    }

    public String getDescriptionModule() {
        return descriptionModule;
    }

    public void setDescriptionModule(String descriptionModule) {
        this.descriptionModule = descriptionModule;
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
