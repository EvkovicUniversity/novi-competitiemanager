package com.example.novi.ncmdb.domain.competitiemanager.formula1.races;

import com.example.novi.ncmdb.domain.competitiemanager.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Races {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "races")
    private Competitie competitie;

    @JsonIgnore
    @OneToMany(
            mappedBy = "races",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Raceuitslag> raceResultaten = new ArrayList<>();

    /**
     * CONSTRUCTORS
     **/
    public Races() {
    }

    /**
     * GETTERS & SETTERS
     **/
    public Long getId() {
        return id;
    }

    public Competitie getCompetitie() {
        return competitie;
    }

    public List<Raceuitslag> getRaceResultaten() {
        return raceResultaten;
    }

    public void setCompetitie(Competitie competitie) {
        this.competitie = competitie;
    }

    public void setRaceResultaten(List<Raceuitslag> raceResultaten) {
        this.raceResultaten = raceResultaten;
    }
}
