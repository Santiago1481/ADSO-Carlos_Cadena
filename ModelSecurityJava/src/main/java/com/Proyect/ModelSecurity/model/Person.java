package com.Proyect.ModelSecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPerson", length = 10)
    private int IdPerson;


    @Column(name = "FirstName", length = 20)
    private String FirstName;

    @Column(name = "LastName", length = 20)
    private String LastName;

    @Column(name = "Gamail", length = 30)
    private String Gmail;

    @Column(name = "Phone", length = 15)
    private int Phone;

    @Column(name = "Active" , length  = 10 )
    private int Active;

    //CONTRUCTOR VACIO

    public Person() {
    }
    // CONTRUCTORES CON PARAMETROS

    public Person(int idPerson, String firstName, String lastName, String gmail, int phone, int active) {
        IdPerson = idPerson;
        FirstName = firstName;
        LastName = lastName;
        Gmail = gmail;
        Phone = phone;
        Active = active;
    }

    //GETERS AND SETERS
    public int getId_Person() {
        return IdPerson;
    }

    public void setId_Person(int id_Person) {
        IdPerson = id_Person;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getActive() {
        return Active;
    }

    public void setActive(int active) {
        Active = active;
    }
   
    
    
}
