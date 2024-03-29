package com.example.novi.ncmdb.service.formula1;

import com.example.novi.ncmdb.model.formula1.Coureur;
import com.example.novi.ncmdb.model.formula1.Raceuitslag;
import com.example.novi.ncmdb.repository.formula1.CoureurRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CoureurService {

    private final CoureurRepository coureurRepository;

    public CoureurService(CoureurRepository coureurRepository) {
        this.coureurRepository = coureurRepository;
    }

    public Iterable<Coureur> saveAll(List<Coureur> entities) {
        return coureurRepository.saveAll(entities);
    }

    public List<Coureur> findAll() {
        return coureurRepository.findAll();
    }

    public Coureur findById(Long id) {
        return coureurRepository.findById(id).get();
    }

    public void addCoureur(Coureur coureur) {
        coureurRepository.save(coureur);
    }

    public ArrayList<Coureur> generateF1Match() {
        List<Coureur> coureurs = getCoureurLijstLocal();
        List<Coureur> einduitslag;

        einduitslag = berekenF1Uitslag(coureurs);
        einduitslag = sorteerLijstOpEindpositie(einduitslag);
        kenEindpositieToe(einduitslag);

        ArrayList<Coureur> einduitslagArray = new ArrayList<>();

        einduitslagArray.addAll(einduitslag);
        return einduitslagArray;
    }

    private List<Coureur> berekenF1Uitslag(List<Coureur> coureurs) {
        List<Coureur> resultaat = new ArrayList<>();

        for (int index = 0; index < 20; index++) {
            Coureur c = coureurs.get(index);

            Double eindpositie = ((Math.random()) * c.getWinfactor() * 100000);
            Long eindpositieId = eindpositie.longValue();

            Coureur coureurGefinished = new Coureur(eindpositieId, c.getName(), 1);

            resultaat.add(coureurGefinished);
        }

        return resultaat;
    }

    private List<Coureur> sorteerLijstOpEindpositie(List<Coureur> resultaat) {
        resultaat.sort(Comparator.comparing(Coureur::getId).reversed());

        return resultaat;
    }

    private List<Coureur> getCoureurLijstViaDB() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Coureur>> responseEntity = template.exchange(
                "http://localhost:8080/competitiemanager/formula1/vanillaCoureurs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Coureur>>() {
                });

        return responseEntity.getBody();
    }

    void kenEindpositieToe(List<Coureur> resultaat) {
        for (int i = 0; i < 20; i++) {
            int eindpositie = i + 1;
            resultaat.get(i).setEindpositie(eindpositie);
        }
    }

    public List<Coureur> geefLijstCoureursMetEindpositieGekoppeldAanRaceuitslag(List<Coureur> raceresultaten, Raceuitslag koppelAanRaceuitslag) {
        List<Coureur> lijstMetNieuweCoureurObjecten = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Coureur eenCoureur = raceresultaten.get(i);
            lijstMetNieuweCoureurObjecten.add(new Coureur(eenCoureur.getName(), eenCoureur.getEindpositie(), koppelAanRaceuitslag));
        }
        return lijstMetNieuweCoureurObjecten;
    }

    public void koppelCoureurAanRaceuitslag(List<Coureur> genmatch, Raceuitslag uitslag) {
        for (Coureur c : genmatch) {
            c.setRaceuitslag(uitslag);
        }

        coureurRepository.saveAll(genmatch);
    }

    private List<Coureur> getCoureurLijstLocal() {
        List<Coureur> coureurs = new ArrayList<>();

        coureurs.add(new Coureur("Alexander Albon", 1));
        coureurs.add(new Coureur("Fernando Alonso", 1));
        coureurs.add(new Coureur("Valtteri Bottas", 1));
        coureurs.add(new Coureur("Pierre Gasly", 1));
        coureurs.add(new Coureur("Lewis Hamilton", 1));
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
        coureurs.add(new Coureur("Max Verstappen", 1));
        coureurs.add(new Coureur("Sebastian Vettel", 1));
        coureurs.add(new Coureur("Guanyu Zhou", 1));

        return coureurs;
    }

}
