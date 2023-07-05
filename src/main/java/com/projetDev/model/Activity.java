package com.projetDev.model;

import org.bson.types.ObjectId;

import java.util.Date;

public class Activity {
    /*
    • un nom
    • une durée (en minutes)
    • une date
    • un RPE (ressenti post-effort)
    • une charge (produit entre la durée et du RPE)
     */
    private ObjectId id;
    private String name;
    private int duration;
    private Date publishedDate;
    private int rpe;
    private int charge;

    public Activity(String name, int duration, int rpe,Date date){
        this.name = name;
        this.duration = duration;
        this.publishedDate = date;
        this.rpe = rpe;
        this.charge = rpe*duration;
    }
    public Activity( ObjectId id,String name, int duration, Date publishedDate, int rpe, int charge){
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.publishedDate = publishedDate;
        this.rpe = rpe;
        this.charge = charge;
    }
    public ObjectId getId() {
        return id;
    }

    public String toString(){
        return "Activity: " + this.id +" " + this.name + " " + this.duration + " " + this.publishedDate + " " + this.rpe + " " + this.charge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getRpe() {
        return rpe;
    }

    public void setRpe(int rpe) {
        this.rpe = rpe;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }




}
