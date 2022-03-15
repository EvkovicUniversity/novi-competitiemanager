package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CoureurService {

    private final CoureurRepository coureurRepository;

    public CoureurService(CoureurRepository coureurRepository) {
        this.coureurRepository = coureurRepository;
    }

    public List<Coureur> findAll() {
        return coureurRepository.findAll();
    }

    public List<Coureur> generateF1Match() {
        List<Coureur> coureurs = getCoureurLijst();
        List<Coureur> einduitslag;

        einduitslag = berekenF1Uitslag(coureurs);

        return sorteerLijstOpEindPositie(einduitslag);
    }

    private List<Coureur> berekenF1Uitslag(List<Coureur> coureurs) {
        List<Coureur> resultaat = new ArrayList<>();

        for (int index = 0; index < 20; index++) {
            Coureur c = coureurs.get(index);

            Double eindpositie = ((Math.random()) * c.getWinfactor() * 100000);
            Long eindpositieId = eindpositie.longValue();

            Coureur coureurGefinished = new Coureur(eindpositieId, c.getName());

            resultaat.add(coureurGefinished);
        }

        return resultaat;
    }

    private List<Coureur> sorteerLijstOpEindPositie(List<Coureur> resultaat) {
        resultaat.sort(Comparator.comparing(Coureur::getId).reversed());

        return resultaat;
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
