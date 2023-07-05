package com.projetDev.model;

import java.util.Date;

public class User {
    /*
    • nom
    • prénom
    • date de naissance
    • sexe
     */
    private String name;
    private String firstName;
    private Date birthDate;
    private String genre;

    public User(String name, String firstName, Date birthDate, String genre) {
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
