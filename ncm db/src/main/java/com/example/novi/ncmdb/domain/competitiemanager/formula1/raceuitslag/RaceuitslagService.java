package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.competitie.CompetitieService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceuitslagService {

    private final RaceuitslagRepository raceuitslagRepository;
    private final CompetitieService competitieService;
    private final CoureurService coureurService;

    public RaceuitslagService(RaceuitslagRepository raceuitslagRepository, CompetitieService competitieService, CoureurService coureurService) {
        this.raceuitslagRepository = raceuitslagRepository;
        this.competitieService = competitieService;
        this.coureurService = coureurService;
    }

    public void save(Raceuitslag raceuitslag){
        raceuitslagRepository.save(raceuitslag);
    }

    public List<Raceuitslag> findAll() {
        return raceuitslagRepository.findAll();
    }

    public Raceuitslag findById(Long id) {
        return raceuitslagRepository.findById(id).get();
    }

    public void doRace(Long competitieId) {
        Competitie competitie = competitieService.findById(competitieId);
        Races races = competitie.getRaces();
        List<Raceuitslag> raceuitslagen = races.getRaceResultaten();

        Raceuitslag nieuweUitslag = new Raceuitslag(races);
        save(nieuweUitslag);
        List<Coureur> nieuweRace = coureurService.generateF1Match();
        nieuweRace = coureurService.geefLijstMetNieuweCoureurObjecten(nieuweRace, nieuweUitslag);

        coureurService.saveAll(nieuweRace);
        raceuitslagen.add(nieuweUitslag);

    }
}
