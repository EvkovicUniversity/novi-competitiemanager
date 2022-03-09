package com.example.novi.ncmdb.domain;

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
}
