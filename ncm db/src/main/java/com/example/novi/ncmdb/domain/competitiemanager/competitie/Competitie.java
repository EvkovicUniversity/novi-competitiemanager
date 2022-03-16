package com.example.novi.ncmdb.domain.competitiemanager.competitie;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;

import javax.persistence.*;

@Entity
public class Competitie {

    @Id
    @GeneratedValue
    private Long id;
    private String competitienaam;

    @OneToOne
    @JoinColumn(name = "races_id", referencedColumnName = "id")
    private Races races;

//    @JsonIgnore
//    @OneToMany(mappedBy = "competitie")
//    private Set<Raceuitslag> races = new HashSet<>();

    /**
     * CONSTRUCTORS
     **/
    public Competitie(){}

    public Competitie(String competitienaam){
        this.competitienaam = competitienaam;
    }

    public Competitie(String competitienaam, Races races) {
        this.competitienaam = competitienaam;
        this.races = races;
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

    public void assignRaces(Races races){
        this.races = races;
    }

//    public Set<Raceuitslag> getRaces() {
//        return races;
//    }
}
