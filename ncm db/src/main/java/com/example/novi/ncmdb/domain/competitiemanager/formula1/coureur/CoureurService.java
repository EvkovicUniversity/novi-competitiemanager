package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
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

    public Iterable<Coureur> saveAll(List<Coureur> entities){
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
        List<Coureur> coureurs = getCoureurLijstViaDB();
//        List<Coureur> coureurs = getCoureurLijstLocal();
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
                "http://localhost:8080/formula1/vanillaCoureurs",
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

    public List<Coureur> geefLijstMetNieuweCoureurObjecten(List<Coureur> raceresultaten, Raceuitslag koppelAanRaceuitslag) {
        List<Coureur> lijstMetNieuweCoureurObjecten = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Coureur eenCoureur = raceresultaten.get(i);
            lijstMetNieuweCoureurObjecten.add(new Coureur(eenCoureur.getName(), eenCoureur.getEindpositie(), koppelAanRaceuitslag));
        }
        return lijstMetNieuweCoureurObjecten;
    }

}
