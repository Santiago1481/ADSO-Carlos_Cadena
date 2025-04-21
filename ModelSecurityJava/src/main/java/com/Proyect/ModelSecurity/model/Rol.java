package com.Proyect.ModelSecurity.model;

import java.util.Set;

import jakarta.persistence.CascadeType;

// import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToMany;
@Entity(name = "Rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRoles", length = 10)
    private int IdRoles;

    @Column(name = "namerol", length = 30)
    private String namerol;

    @Column(name = "Description", length = 150)
    private String Description;

    @Column(name = "Active", length =  5)
    private int Active;
    
    // Contructor vacio 
    public Rol() {
    }

    //Contructro con parametros 
    public Rol(int idRoles, String namerol, String description, int active) {
        IdRoles = idRoles;
        this.namerol = namerol;
        Description = description;
        Active = active;
    }

    public int getId_Roles() {
        return IdRoles;
    }

    public void setId_Roles(int id_Roles) {
        IdRoles = id_Roles;
    }

    public String getNamerol() {
        return namerol;
    }

    public void setNamerol(String namerol) {
        this.namerol = namerol;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }

    // @OneToMany(mappedBy = "rol")
    // private List<RolUser> rolUsers;}

        @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
        private Set<RolFormPermission> rolFormPermissions;
}
