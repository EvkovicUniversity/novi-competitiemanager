package com.example.novi.ncmdb.model.formula1;

import javax.persistence.*;

@Entity
public class Coureur {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int eindpositie;
    double winfactor;

    @ManyToOne
    @JoinColumn(name = "raceuitslag_id")
    private Raceuitslag raceuitslag;

    @OneToOne
    private Voorspelling voorspelling;


    /**
     * CONSTRUCTORS
     **/
    public Coureur() {

    }

    public Coureur(String name, double winfactor) {
        this.name = name;
        this.winfactor = winfactor;
    }

    public Coureur(Long id, String name, int eindpositie) {
        this.id = id;
        this.name = name;
        this.eindpositie = eindpositie;
    }

    public Coureur(Raceuitslag raceuitslag) {
        this.raceuitslag = raceuitslag;
    }

    public Coureur(String name, int eindpositie, Raceuitslag raceuitslag) {
        this.name = name;
        this.eindpositie = eindpositie;
        this.raceuitslag = raceuitslag;
    }

    /**
     * GETTERS & SETTERS
     **/
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWinfactor() {
        return winfactor;
    }

    public int getEindpositie() {
        return eindpositie;
    }

    public void setEindpositie(int eindpositie) {
        this.eindpositie = eindpositie;
    }

    public void setRaceuitslag(Raceuitslag raceuitslag) {
        this.raceuitslag = raceuitslag;
    }

    public Raceuitslag getRaceuitslag() {
        return raceuitslag;
    }
}
