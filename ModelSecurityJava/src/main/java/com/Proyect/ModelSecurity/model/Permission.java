package com.Proyect.ModelSecurity.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPermission", length = 15)
    private int IdPermission;

    @Column(name = "namePermission" , length = 50)
    private String namePermission;

    @Column(name = "descriptionPer", length = 150)
    private String descriptionName;

    @Column(name = "active", length = 5)
    private int active;

    public Permission() {
    }

    public Permission(int id_Permission, String namePermission, String descriptionName, int active) {
        IdPermission = id_Permission;
        this.namePermission = namePermission;
        this.descriptionName = descriptionName;
        this.active = active;
    }

    public int getId_Permission() {
        return IdPermission;
    }

    public void setId_Permission(int id_Permission) {
        IdPermission = id_Permission;
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

    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL)
    private Set<RolFormPermission> rolFormPermissions;

}
