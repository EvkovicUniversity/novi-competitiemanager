package com.example.novi.ncmdb.domain.authenticatie.gebruiker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue
    private Long id;
    private String gebruikersnaam;
    private String wachtwoord;
    /**
     * CONSTRUCTORS
     **/
    public Gebruiker(){}

    /**
     * GETTERS & SETTERS
     **/
    public Long getId() {
        return id;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

}
