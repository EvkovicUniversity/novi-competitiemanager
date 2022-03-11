package com.example.novi.ncmdb.domain.Formula1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Comparator;

@Entity
public class Coureur {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    double winfactor;

    public Coureur(String name, double winfactor){
        this.name = name;
        this.winfactor = winfactor;
    }

    public Coureur(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Coureur() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWinfactor() {
        return winfactor;
    }
}
