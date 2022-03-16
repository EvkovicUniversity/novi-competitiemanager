package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coureur {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int eindpositie;
    double winfactor;

    /**
     * CONSTRUCTORS
     **/
    public Coureur() {

    }

//    @JsonIgnore
//    @ManyToMany(mappedBy = "coureurs")
//    private Set<Raceuitslag> raceuitslagen = new HashSet<>();

    public Coureur(String name, double winfactor) {
        this.name = name;
        this.winfactor = winfactor;
    }

    public Coureur(Long id, String name, int eindpositie) {
        this.id = id;
        this.name = name;
        this.eindpositie = eindpositie;
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

//    public Set<Raceuitslag> getRaceuitslagen() {
//        return raceuitslagen;
//    }

    public int getEindpositie() {
        return eindpositie;
    }

    public void setEindpositie(int eindpositie){
        this.eindpositie=eindpositie;
    }
}
