package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoorspellingService {

    private final VoorspellingRepository voorspellingRepository;

    public VoorspellingService(VoorspellingRepository voorspellingRepository){
        this.voorspellingRepository = voorspellingRepository;
    }

//    public void addVoorspelling(Integer voorspellingswaarde, Long raceId, Long coureurId) {
//        Voorspelling voorspelling = new Voorspelling();
//        voorspelling.setVoorspellingEindpositie(voorspellingswaarde);
//        voorspelling.setRace(raceId);
//        voorspelling.setCoureurId(coureurId);
//
//    }

    public Voorspelling findById(Long voorspellingId) {
        return voorspellingRepository.findById(voorspellingId).get();
    }

//    public Iterable<Voorspelling> findByRaceuitslag(Long raceuitslagId){
////        return voorspellingRepository.findById(raceuitslagId)
//    }
}
