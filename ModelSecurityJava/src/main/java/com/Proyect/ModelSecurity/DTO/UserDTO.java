package com.Proyect.ModelSecurity.DTO;

public class UserDTO {

    private int Id_Users;  
    private String nameusers;  
    private String gmail; 
    private int Active; 
    private String rol; 

    // Constructor vacío
    public UserDTO() {}

    // Constructor con parámetros
    public UserDTO(int Id_Users, String nameusers, String gmail, int Active, String rol) {
        this.Id_Users = Id_Users;
        this.nameusers = nameusers;
        this.gmail = gmail;
        this.Active = Active;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId_Users() {
        return Id_Users;
    }

    public void setId_Users(int Id_Users) {
        this.Id_Users = Id_Users;
    }

    public String getNameusers() {
        return nameusers;
    }

    public void setNameusers(String nameusers) {
        this.nameusers = nameusers;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int Active) {
        this.Active = Active;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
