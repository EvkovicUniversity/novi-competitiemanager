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

    public Gebruiker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    /**
     * GETTERS & SETTERS
     **/
    public Long getId() {
        return id;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
}
