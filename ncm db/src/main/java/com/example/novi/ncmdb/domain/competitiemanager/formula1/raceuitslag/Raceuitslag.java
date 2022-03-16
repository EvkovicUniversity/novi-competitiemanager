package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;

import javax.persistence.*;

@Entity
public class Raceuitslag {

    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "competitie_id", referencedColumnName = "id")
//    private Competitie competitie;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "raceuitkomst",
//            joinColumns = @JoinColumn(name = "raceuitslagId"),
//            inverseJoinColumns = @JoinColumn(name = "coureurId")
//    )
//    private Set<Coureur> coureurs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "races_id", referencedColumnName = "id")
    private Races races;

    /**
    * CONSTRUCTORS
    **/
    public Raceuitslag(){}

    /**
    * GETTERS & SETTERS
    **/
    public Long getId() {
        return id;
    }

    public Races getRaces(){
        return this.races;
    }

    public void assignToRaces(Races races){
        this.races = races;
    }

//    public Competitie getCompetitie() {
//        return competitie;
//    }

//    public Set<Coureur> getRaceuitslag() {
//        return coureurs;
//    }
//
//    public void assignCoureur(Coureur coureur){
//        coureurs.add(coureur);
//    }
//
//    public void assignCompetitie(Competitie competitie) {
//        this.competitie = competitie;
//    }
}
