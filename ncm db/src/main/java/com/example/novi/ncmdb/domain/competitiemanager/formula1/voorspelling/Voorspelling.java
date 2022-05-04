package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;

import javax.persistence.*;

@Entity
public class Voorspelling {

    @Id
    @GeneratedValue
    private Long id;
    private String gebruiker;
    private String coureurNaam;

    @ManyToOne
    @JoinColumn(name = "raceuitslag_id", referencedColumnName = "id")
    private Raceuitslag raceuitslag;

    private Integer voorspellingEindpositie;

    /**
     * CONSTRUCTORS
     **/
    public Voorspelling() {
    }

    /**
     * GETTERS & SETTERS
     **/
    public Raceuitslag getRaceuitslag() {
        return raceuitslag;
    }

    public void setRaceuitslag(Raceuitslag raceuitslag) {
        this.raceuitslag = raceuitslag;
    }

    public String getCoureurNaam() {
        return coureurNaam;
    }

    public void setCoureurNaam(String coureurNaam) {
        this.coureurNaam = coureurNaam;
    }

    public Integer getVoorspellingEindpositie() {
        return voorspellingEindpositie;
    }

    public void setVoorspellingEindpositie(Integer voorspellingEindpositie) {
        this.voorspellingEindpositie = voorspellingEindpositie;
    }
}
