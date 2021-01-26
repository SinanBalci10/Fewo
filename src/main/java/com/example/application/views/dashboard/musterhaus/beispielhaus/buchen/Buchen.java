package com.example.application.views.dashboard.musterhaus.beispielhaus.buchen;

public class Buchen {

    private String uberschrift;
    private String zeitraum;
    private String personenzahl;
    private String bezahlmethode;
    private String preis;


    public Buchen(){

    }

    public String getUberschrift() {
        return uberschrift;
    }

    public void setUberschrift(String uberschrift) {
        this.uberschrift = uberschrift;
    }

    public String getZeitraum() {
        return zeitraum;
    }

    public void setZeitraum(String zeitraum) {
        this.zeitraum = zeitraum;
    }

    public String getPersonenzahl() {
        return personenzahl;
    }

    public void setPersonenzahl(String personenzahl) {
        this.personenzahl = personenzahl;
    }

    public String getBezahlmethode() {
        return bezahlmethode;
    }

    public void setBezahlmethode(String bezahlmethode) {
        this.bezahlmethode = bezahlmethode;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }
}
