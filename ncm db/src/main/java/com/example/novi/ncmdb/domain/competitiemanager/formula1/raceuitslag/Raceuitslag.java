package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Raceuitslag {

    @Id
    @GeneratedValue
    private Long id;
    private String testRace;


    /**
    * CONSTRUCTORS
    **/
    public Raceuitslag(){}

    public Raceuitslag(String testRace){
        this.testRace = testRace;
    }

    /**
    * GETTERS & SETTERS
    **/
    public Long getId() {
        return id;
    }

    public String getTestRace() {
        return testRace;
    }



}
