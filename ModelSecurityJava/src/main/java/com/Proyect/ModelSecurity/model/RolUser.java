package com.Proyect.ModelSecurity.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roluser")
public class RolUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "RolId", nullable = false)
    private Rol rol;

    @Column(name = "active")
    private Boolean deleted = false;  // Valor por defecto en 'false' para relaciones activas

    public RolUser() {
    }

    public RolUser(Long id, Users user, Rol rol) {
        this.id = id;
        this.user = user;
        this.rol = rol;
        this.deleted = false;  // Aseguramos que por defecto esté en 'false'
    }

    // Métodos getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Boolean getDeleted() {  // Se cambia 'isDeleted()' a 'getDeleted()'
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
