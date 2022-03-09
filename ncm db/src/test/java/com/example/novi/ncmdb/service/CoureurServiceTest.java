package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.Coureur;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.inject.Inject;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class CoureurServiceTest {

    private CoureurService sut;

    @Test
    public void findAllTest() {
        sut.findAll();
    }

    @Test
    void generateF1Match() {

        List<Coureur> coureurs = getCoureurLijst();
        List<Coureur> nieuweOrde = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Coureur c = coureurs.get(i);

            Double positie = (Math.random());
//                    * c.getWinfactor() * 100000);
            Long positieInt = positie.longValue();

            System.out.println(positie);

            Coureur c2 = new Coureur(positieInt, c.getName());

            nieuweOrde.add(c2);
        }

        nieuweOrde.sort(Comparator.comparing(Coureur::getId).reversed());
        for (int i = 0; i < 20; i++) {
            int plaats = i + 1;
//            System.out.println(plaats + "e plaats: " + nieuweOrde.get(i).getName() + " met waarde " + nieuweOrde.get(i).getId());
        }

    }

    private List<Coureur> getCoureurLijst() {
        List<Coureur> coureurs = new ArrayList<>();

        coureurs.add(new Coureur("Alexander Albon", 1));
        coureurs.add(new Coureur("Fernando Alonso", 1));
        coureurs.add(new Coureur("Valtteri Bottas", 1));
        coureurs.add(new Coureur("Pierre Gasly", 1));
        coureurs.add(new Coureur("Lewis Hamilton", 6));
        coureurs.add(new Coureur("Nicholas Latifi", 1));
        coureurs.add(new Coureur("Charles Leclerc", 1));
        coureurs.add(new Coureur("Nikita Mazepin", 1));
        coureurs.add(new Coureur("Lando Norris", 1));
        coureurs.add(new Coureur("Esteban Ocon", 1));
        coureurs.add(new Coureur("Sergio Pérez", 1));
        coureurs.add(new Coureur("Daniel Ricciardo", 1));
        coureurs.add(new Coureur("George Russell", 1));
        coureurs.add(new Coureur("Carlos Sainz jr.", 1));
        coureurs.add(new Coureur("Mick Schumacher", 1));
        coureurs.add(new Coureur("Yuki Tsunoda", 1));
        coureurs.add(new Coureur("Lance Stroll", 1));
        coureurs.add(new Coureur("Max Verstappen", 5));
        coureurs.add(new Coureur("Sebastian Vettel", 1));
        coureurs.add(new Coureur("Guanyu Zhou", 1));

        return coureurs;
    }

}
