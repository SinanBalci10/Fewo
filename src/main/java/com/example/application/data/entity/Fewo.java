package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Fewo extends AbstractEntity {


    public Integer getPersonen() {
        return personen;
    }

    public void setPersonen(Integer personen) {
        this.personen = personen;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Integer getSterne() {
        return sterne;
    }

    public void setSterne(Integer sterne) {
        this.sterne = sterne;
    }

    public Integer getSchlafzimmer() {
        return schlafzimmer;
    }

    public void setSchlafzimmer(Integer schlafzimmer) {
        this.schlafzimmer = schlafzimmer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fewo() {

    }

    private Integer personen;
    private String ort;
    private Integer sterne;
    private Integer schlafzimmer;
    private String name;

}