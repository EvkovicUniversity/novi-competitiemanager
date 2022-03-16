package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Coureur {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int eindpositie;
    double winfactor;

    @ManyToMany(mappedBy = "coureurs")
    private Set<Raceuitslag> raceuitslagen = new HashSet<>();

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

    public Set<Raceuitslag> getRaceuitslagen() {
        return raceuitslagen;
    }

}
