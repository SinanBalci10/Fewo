package com.example.application.views.dashboard;

public class Suchleiste {

    private String uberschrift;
    private String filter;
    private String ort;
    private String verfugrbarvon;
    private String verfugrbarbis;
    private String personenzahl;

    public String getVerfugrbarvon() {
        return verfugrbarvon;
    }

    public void setVerfugrbarvon(String verfugrbarvon) {
        this.verfugrbarvon = verfugrbarvon;
    }

    public String getVerfugrbarbis() {
        return verfugrbarbis;
    }

    public void setVerfugrbarbis(String verfugrbarbis) {
        this.verfugrbarbis = verfugrbarbis;
    }

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



    public String getPersonenzahl() {
        return personenzahl;
    }

    public void setPersonenzahl(String personenzahl) {
        this.personenzahl = personenzahl;
    }
}
