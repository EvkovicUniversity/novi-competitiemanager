package com.example.novi.ncmdb.model.formula1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Competitie {

    @Id
    @GeneratedValue
    private Long id;
    private String competitienaam;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "races_id", referencedColumnName = "id")
    private Races races;

    /**
     * CONSTRUCTORS
     **/
    public Competitie() {
    }

    public Competitie(String competitienaam) {
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

    public Races getRaces() {
        return races;
    }

    public void setRaces(Races races) {
        this.races = races;
    }

}
