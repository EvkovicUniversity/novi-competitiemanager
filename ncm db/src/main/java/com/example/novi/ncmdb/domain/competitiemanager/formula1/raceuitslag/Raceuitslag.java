package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Raceuitslag {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "races_id", referencedColumnName = "id")
    private Races races;

    @OneToMany(
            mappedBy = "raceuitslag",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Coureur> raceuitkomst = new ArrayList<>();

    /**
    * CONSTRUCTORS
    **/
    public Raceuitslag(){}

    public Raceuitslag(Races races){
        this.races = races;
    }

    /**
    * GETTERS & SETTERS
    **/
    public Long getId() {
        return id;
    }

    public Races getRaces(){
        return this.races;
    }

    public void setRaces(Races races){
        this.races = races;
    }

    public void setRaceuitkomst(List<Coureur> raceuitkomst) {
        this.raceuitkomst = raceuitkomst;
    }
}
