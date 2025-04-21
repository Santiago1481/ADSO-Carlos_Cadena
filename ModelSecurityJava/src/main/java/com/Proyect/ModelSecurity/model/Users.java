package com.Proyect.ModelSecurity.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsers", length = 10)
    private int IdUsers;

    @Column(name = "nameusers", length = 30)
    private String nameusers;

    @Column(name = "gmail", length = 30)
    private String gmail;

    @Column(name = "Pasword", length = 12)
    private String Pasword;

    @Column(name = "Active", length =  5)
    private int Active;




    // CONSTRUCTOR VACIO
    public Users() {
    }


    // crear contructor con datos 
    public Users(int id_Users, String nameusers, String gmail, String Pasword, int active) {
        IdUsers = id_Users;
        this.nameusers = nameusers;
        this.gmail = gmail;
        this.Pasword = Pasword;
        Active = active;
    }

    // crear GET Y SET
    public int getId_Users() {
        return IdUsers;
    }


    public void setId_Users(int id_Users) {
        IdUsers = id_Users;
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


    public String getPasword() {
        return Pasword;
    }


    public void setPasword(String Pasword) {
        this.Pasword = Pasword;
    }


    public int getActive() {
        return Active;
    }


    public void setActive(int active) {
        Active = active;
    }

    @OneToOne
    @JoinColumn(name = "PersonId")
    private Person person;
}
