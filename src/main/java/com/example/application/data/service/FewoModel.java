//package com.example.application.data.service;
//
//
//import com.example.application.data.AbstractEntity;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "fewo")
//public class FewoModel extends AbstractEntity {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "ort")
//    private String ort;
//
//    @Column(name = "von")
//    private LocalDate von;
//
//    @Column(name = "bis")
//    private LocalDate bis;
//
//    @Column(name = "personenzahl")
//    private String personenzahl;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "schlafzimmer")
//    private Integer schlafzimmer;
//
//    @Column(name = "quadratmeter")
//    private Integer quadratmeter;
//
//    @Column(name = "preis")
//    private Integer preis;
//
//    @Column(name = "sterne")
//    private String sterne;
//
//    @Override
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getOrt() {
//        return ort;
//    }
//
//    public void setOrt(String ort) {
//        this.ort = ort;
//    }
//
//    public LocalDate getVon() {
//        return von;
//    }
//
//    public void setVon(LocalDate von) {
//        this.von = von;
//    }
//
//    public LocalDate getBis() {
//        return bis;
//    }
//
//    public void setBis(LocalDate bis) {
//        this.bis = bis;
//    }
//
//    public String getPersonenzahl() {
//        return personenzahl;
//    }
//
//    public void setPersonenzahl(String personenzahl) {
//        this.personenzahl = personenzahl;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getSchlafzimmer() {
//        return schlafzimmer;
//    }
//
//    public void setSchlafzimmer(Integer schlafzimmer) {
//        this.schlafzimmer = schlafzimmer;
//    }
//
//    public Integer getQuadratmeter() {
//        return quadratmeter;
//    }
//
//    public void setQuadratmeter(Integer quadratmeter) {
//        this.quadratmeter = quadratmeter;
//    }
//
//    public Integer getPreis() {
//        return preis;
//    }
//
//    public void setPreis(Integer preis) {
//        this.preis = preis;
//    }
//
//    public String getSterne() {
//        return sterne;
//    }
//
//    public void setSterne(String sterne) {
//        this.sterne = sterne;
//    }
//}
