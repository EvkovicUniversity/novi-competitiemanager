package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import javax.persistence.*;

@Entity
public class Coureur {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    double winfactor;

    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "coureur_id", referencedColumnName = "id")
//    private Raceuitslag raceuitslag;

    /**
     * CONSTRUCTORS
     **/
    public Coureur() {

    }

    public Coureur(String name, double winfactor) {
        this.name = name;
        this.winfactor = winfactor;
    }

    public Coureur(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * GETTERS & SETTERS
     **/
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWinfactor() {
        return winfactor;
    }

//    public Raceuitslag getRaceuitslag() {
//        return raceuitslag;
//    }
}
