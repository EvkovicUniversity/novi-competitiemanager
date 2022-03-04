package com.example.novi.ncmdb.domain;

import javax.persistence.*;

@Entity
@Table(name = "coureurs")
public class Coureur {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "winfactor")
    double winfactor;

    public Coureur(String name, double winfactor){
        this.name = name;
        this.winfactor = winfactor;
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
