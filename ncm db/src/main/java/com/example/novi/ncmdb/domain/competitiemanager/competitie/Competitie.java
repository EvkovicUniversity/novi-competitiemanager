package com.example.novi.ncmdb.domain.competitiemanager.competitie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Competitie {

    @Id
    @GeneratedValue
    private Long id;
    private String competitienaam;

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

}
