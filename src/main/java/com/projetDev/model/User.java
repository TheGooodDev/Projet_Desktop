package com.projetDev.model;

public class User {
    /*
    • nom
    • prénom
    • date de naissance
    • sexe
     */
    private String name;
    private String firstName;
    private String birthDate;
    private String genre;

    public User(String name, String firstName, String birthDate, String genre) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
