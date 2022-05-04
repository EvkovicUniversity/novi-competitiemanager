package com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitieService {

    private final CompetitieRepository repository;
    private final RacesService racesService;

    public CompetitieService(CompetitieRepository repository, RacesService racesService) {
        this.repository = repository;
        this.racesService = racesService;
    }

    public List<Competitie> findAll() {
        return repository.findAll();
    }

    public Competitie findById(Long id) {
        return repository.findById(id).get();
    }

    public Competitie save(Competitie competitie) {
        return repository.save(competitie);
    }

    public Competitie addCompetitie(Competitie competitie) {

        Competitie savedCompetitie = save(new Competitie(competitie.getCompetitienaam()));

        //Maak races aan gekoppeld aan competitie
        Races races = new Races(savedCompetitie);

        //Sla races op
        Races savedRaces = racesService.save(races);

        //Koppel races aan competitie
        savedCompetitie.setRaces(savedRaces);
        save(savedCompetitie);

        Raceuitslag raceuitslag = new Raceuitslag(savedRaces);
        raceuitslag.setId(false);

        return repository.save(competitie);
    }
}
