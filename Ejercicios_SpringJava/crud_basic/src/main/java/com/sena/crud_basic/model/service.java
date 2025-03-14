package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "service")
public class service {

    //@id indica que es la primary key
    @Id
    //@column=indica que es una columna 
    /*
     * name= nombre de la columna en basde de datos
     * length=longitud del campo
     * mullable=si acepata nlo o no nulo
     */
    @Column(name = "id_service",length = 10, nullable = false)
    private int id_service;
    @Column(name = "name",length = 50, nullable = false)
    private String name;
    @Column(name = "description",length = 200, nullable = false)
    private String description;
    public service(int id_service, String name, String description) {
        this.id_service = id_service;
        this.name = name;
        this.description = description;
    }
    public int getId_service() {
        return id_service;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setId_service(int id_service) {
        this.id_service = id_service;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    

}
