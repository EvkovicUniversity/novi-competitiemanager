package com.example.novi.novicompetitiemanagerbackend.domain.formule1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coureurs {
    
    @Id
    private long id;
    private String name;
    private long winfactor;
    
}
