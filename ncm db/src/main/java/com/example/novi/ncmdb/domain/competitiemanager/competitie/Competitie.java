package com.example.novi.ncmdb.domain.competitiemanager.competitie;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Competitie {

    @Id
    @GeneratedValue
    private Long id;
    private String competitienaam;

    @JsonIgnore
    @OneToMany(mappedBy = "competitie")
    private Set<Raceuitslag> races = new HashSet<>();

    /**
     * CONSTRUCTORS
     **/
    public Competitie(){}

    public Competitie(String competitienaam){
        this.competitienaam = competitienaam;
    }

    /**
     * GETTERS & SETTERS
     **/
    public Long getId() {
        return id;
    }

    public String getCompetitienaam() {
        return competitienaam;
    }

    public Set<Raceuitslag> getRaces() {
        return races;
    }

}
