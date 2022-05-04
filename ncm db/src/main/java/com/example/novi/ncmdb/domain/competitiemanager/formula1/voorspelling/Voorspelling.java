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
    private Long coureurId;

    private String StoneyBoneyID;

    /**
     * CONSTRUCTORS
     **/
    public Voorspelling() {
    }

    public String getStoneyBoneyID() {
        return StoneyBoneyID;
    }

    public void setStoneyBoneyID(String stoneyBoneyID) {
        StoneyBoneyID = stoneyBoneyID;
    }

    /**
     * GETTERS & SETTERS
     **/


    public String getCoureurNaam() {
        return coureurNaam;
    }

    public void setCoureurNaam(String coureurNaam) {
        this.coureurNaam = coureurNaam;
    }

    public void setVoorspellingEindpositie(Integer voorspellingEindpositie) {
        this.voorspellingEindpositie = voorspellingEindpositie;
    }

    public Raceuitslag getRaceUitslagId() {
        return raceuitslag;
    }

    public void setRace(Raceuitslag raceuitslag) {
        this.raceuitslag = raceuitslag;
    }

    public Integer getVoorspellingEindpositie() {
        return voorspellingEindpositie;
    }

    public Long getCoureurId() {
        return coureurId;
    }

    public void setCoureurId(Long coureurId) {
        this.coureurId = coureurId;
    }
}
