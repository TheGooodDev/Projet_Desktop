package com.projetDev.model;

import org.bson.types.ObjectId;

import java.util.Date;

public class User {

    private ObjectId id;
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

    public User(ObjectId id, String name, String firstName, Date birthDate, String genre) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.genre = genre;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
