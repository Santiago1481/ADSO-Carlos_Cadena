package com.Proyect.ModelSecurity.DTO;

import java.time.LocalDateTime;

public class ModuleDTO {

    private int idModule;
    private String nameModule;
    private String descriptionModule;
    private LocalDateTime createDate;
    private int active;

    public ModuleDTO() {
    }

    public ModuleDTO(int idModule, String nameModule, String descriptionModule, LocalDateTime createDate, int active) {
        this.idModule = idModule;
        this.nameModule = nameModule;
        this.descriptionModule = descriptionModule;
        this.createDate = createDate;
        this.active = active;
    }

    public int getIdModule() {
        return idModule;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }

    public String getNameModule() {
        return nameModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule;
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
