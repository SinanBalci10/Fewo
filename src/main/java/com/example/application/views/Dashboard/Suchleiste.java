package com.example.application.views.Dashboard;

public class Suchleiste {

    private String uberschrift;
    private String filter;
    private String ort;
    private String verfugrbar;
    private String personenzahl;


    public Suchleiste() {
    }

    public String getUberschrift() {
        return uberschrift;
    }

    public void setUberschrift(String uberschrift) {
        this.uberschrift = uberschrift;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getVerfugrbar() {
        return verfugrbar;
    }

    public void setVerfugrbar(String verfugrbar) {
        this.verfugrbar = verfugrbar;
    }

    public String getPersonenzahl() {
        return personenzahl;
    }

    public void setPersonenzahl(String personenzahl) {
        this.personenzahl = personenzahl;
    }
}
