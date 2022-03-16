package com.example.novi.ncmdb.domain.competitiemanager.formula1.races;

import com.example.novi.ncmdb.domain.competitiemanager.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;

import javax.persistence.*;
import java.util.List;

@Entity
public class Races {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "races")
    private Competitie competitie;

    @OneToMany(mappedBy = "races")
    private List<Raceuitslag> raceResultaten;
    /**
     * CONSTRUCTORS
     **/
    public Races() {
    }

    public Races(List<Raceuitslag> raceResultaten) {
        this.raceResultaten = raceResultaten;
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

    public void assignCompetitie(Competitie competitie){
        this.competitie = competitie;
    }

    public void assignRaceResultaten(Raceuitslag raceuitslag){
        this.raceResultaten.add(raceuitslag);
    }
}
