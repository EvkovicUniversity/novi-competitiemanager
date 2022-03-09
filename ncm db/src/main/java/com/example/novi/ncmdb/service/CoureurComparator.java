package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.Coureur;

import java.util.Comparator;

public class CoureurComparator implements Comparator<Coureur> {
    @Override
    public int compare(Coureur c1, Coureur c2) {
        return c1.getId().compareTo(c2.getId());
    }
}
