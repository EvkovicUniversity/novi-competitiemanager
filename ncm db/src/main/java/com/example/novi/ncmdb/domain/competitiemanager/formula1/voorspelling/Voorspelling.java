package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voorspelling {

    @Id
    @GeneratedValue
    private Long id;
//    private Coureur coureur;
    private String raceUitslagId;
    private Integer voorspellingEindpositie;

    /**
     * CONSTRUCTORS
     **/
    public Voorspelling() {
    }

    /**
     * GETTERS & SETTERS
     **/
//    public Coureur getCoureur() {
//        return coureur;
//    }
//
//    public void setCoureur(Coureur coureur) {
//        this.coureur = coureur;
//    }

    public void setVoorspellingEindpositie(Integer voorspellingEindpositie) {
        this.voorspellingEindpositie = voorspellingEindpositie;
    }

    public String getRaceUitslagId() {
        return raceUitslagId;
    }

    public void setRace(String raceUitslagId) {
        this.raceUitslagId = raceUitslagId;
    }

    public Integer getVoorspellingEindpositie() {
        return voorspellingEindpositie;
    }
}
