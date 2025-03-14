package com.fastOrder.hello_world.DTO;

public class requestDTO {

    private String firstName;
    private String lastName;
    private String gmail;
    public requestDTO(String firstName, String lastName, String gmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gmail = gmail;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGmail() {
        return gmail;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    
}


