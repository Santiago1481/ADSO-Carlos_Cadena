package com.Proyect.ModelSecurity.DTO;

public class PermissionDTO {

    private int idPermission;
    private String namePermission;
    private String descriptionName;
    private int active;

    // Constructor vacío
    public PermissionDTO() {}

    // Constructor con parámetros
    public PermissionDTO(int idPermission, String namePermission, String descriptionName, int active) {
        this.idPermission = idPermission;
        this.namePermission = namePermission;
        this.descriptionName = descriptionName;
        this.active = active;
    }

    // Getters y setters
    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public String getNamePermission() {
        return namePermission;
    }

    public void setNamePermission(String namePermission) {
        this.namePermission = namePermission;
    }

    public String getDescriptionName() {
        return descriptionName;
    }

    public void setDescriptionName(String descriptionName) {
        this.descriptionName = descriptionName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
