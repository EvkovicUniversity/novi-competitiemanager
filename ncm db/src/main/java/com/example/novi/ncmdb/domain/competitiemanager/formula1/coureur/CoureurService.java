package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

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

    public List<Coureur> findAll() {
        return coureurRepository.findAll();
    }

    public Coureur findById(Long id){
        return coureurRepository.findById(id).get();
    }

    public void addCoureur(Coureur coureur){
        coureurRepository.save(coureur);
    };

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
        RestTemplate template = new RestTemplate();
        ResponseEntity<List<Coureur>> responseEntity = template.exchange(
                "http://localhost:8080/formula1/coureurs",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Coureur>>() {
                });

    return responseEntity.getBody();
    }

}
