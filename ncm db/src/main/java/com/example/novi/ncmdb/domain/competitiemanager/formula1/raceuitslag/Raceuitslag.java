package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.Voorspelling;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Raceuitslag {

    @Id
    private String id = dummyId();

    @ManyToOne
    @JoinColumn(name = "races_id", referencedColumnName = "id")
    private Races races;

    @JsonIgnore
    @OneToMany(
            mappedBy = "raceuitslag",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Coureur> raceuitkomst = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "raceuitslag",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Voorspelling> voorspellingen = new ArrayList<>();

    /**
     * CONSTRUCTORS
     **/
    public Raceuitslag() {
    }

    public Raceuitslag(Races races) {
        this.races = races;
    }


    /**
     * GETTERS & SETTERS
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public Races getRaces() {
        return this.races;
    }

    public void setRaces(Races races) {
        this.races = races;
    }

    public void setRaceuitkomst(List<Coureur> raceuitkomst) {
        this.raceuitkomst = raceuitkomst;
    }

    public void setId(){
        String cijfer;
        String newID;

        if (this.races.getRaceResultaten().size() < 10){
            cijfer = "0" + this.races.getRaceResultaten().size();
        } else {
            cijfer = "" + this.races.getRaceResultaten().size();
        }

        newID = this.races.getCompetitie().getId() + "Race" + cijfer;

        this.id = newID;
    }

    public List<Coureur> getRaceuitkomst() {
        return raceuitkomst;
    }

    public List<Voorspelling> getVoorspellingen() {
        return voorspellingen;
    }

    private String dummyId() {
        Double randomGetal = Math.random();
        String randomString= randomGetal.toString().substring(2,10);

        return ("TBR" + randomString).substring(0, 10);
    }

}
