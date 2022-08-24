package com.example.novi.ncmdb.model.formula1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Raceuitslag {

    @Id
    private String id = dummyId();
    private boolean isPlayed = false;

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
    public boolean isPlayed() {
        return isPlayed;
    }

    public void setPlayed() {
        isPlayed = true;
    }

    public List<Voorspelling> getVoorspellingen() {
        return voorspellingen;
    }

    public void setVoorspellingen(List<Voorspelling> voorspellingen) {
        this.voorspellingen = voorspellingen;
    }

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

    public void setId(boolean isPrediction) {
        String filler;
        String newID;
        int cijfer;

        if (isPrediction) {
            cijfer = this.races.getRaceResultaten().size() + 1;
        } else {
            cijfer = this.races.getRaceResultaten().size();
        }

        if (this.races.getRaceResultaten().size() < 9) {
            filler = "0";
        } else {
            filler = "";
        }

        newID = this.races.getCompetitie().getId() + "Race" + filler + cijfer;

        this.id = newID;
    }

    public List<Coureur> getRaceuitkomst() {
        return raceuitkomst;
    }

    private String dummyId() {
        Double randomGetal = Math.random();
        String randomString = randomGetal.toString().substring(2, 10);

        return ("TBR" + randomString).substring(0, 10);
    }

}
