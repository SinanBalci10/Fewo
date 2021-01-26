package com.example.application.data.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Fewo {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincrement um 1
    private Integer id;
    private Integer personen;
    private String ort;
    private Integer sterne;
    private Integer schlafzimmer;
    private String name;

}