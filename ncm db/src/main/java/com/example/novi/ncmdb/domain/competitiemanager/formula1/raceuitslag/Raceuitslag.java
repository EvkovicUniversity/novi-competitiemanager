package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Raceuitslag {

    @Id
    @GeneratedValue
    private Long id;
    private String testRace;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "competitie_id", referencedColumnName = "id")
    private Competitie competitie;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "coureursEnrolled",
            joinColumns = @JoinColumn(name = "raceuitslagId"),
            inverseJoinColumns = @JoinColumn(name = "coureurId")
    )
    private Set<Coureur> coureurs = new HashSet<>();

    /**
    * CONSTRUCTORS
    **/
    public Raceuitslag(){}

    public Raceuitslag(String testRace){
        this.testRace = testRace;
    }
    public Raceuitslag(String testRace, Set<Coureur> raceuitslag){
        this.testRace = testRace;
        this.coureurs = raceuitslag;
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

    public Competitie getCompetitie() {
        return competitie;
    }

    public Set<Coureur> getRaceuitslag() {
        return coureurs;
    }

    public void assignCoureur(Coureur coureur){
        coureurs.add(coureur);
    }

    public void assignCompetitie(Competitie competitie) {
        this.competitie = competitie;
    }
}
