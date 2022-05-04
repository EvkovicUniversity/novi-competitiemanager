package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceuitslagService {

    private final RaceuitslagRepository raceuitslagRepository;
    private final CompetitieService competitieService;
    private final CoureurService coureurService;
    private final RacesService racesService;

    public RaceuitslagService(RaceuitslagRepository raceuitslagRepository, CompetitieService competitieService, CoureurService coureurService, RacesService racesService) {
        this.raceuitslagRepository = raceuitslagRepository;
        this.competitieService = competitieService;
        this.coureurService = coureurService;
        this.racesService = racesService;
    }

    public void save(Raceuitslag raceuitslag) {
        raceuitslagRepository.save(raceuitslag);
    }

    public List<Raceuitslag> findAll() {
        return raceuitslagRepository.findAll();
    }

    public Raceuitslag findById(String id) {
        return raceuitslagRepository.findById(id).get();
    }

    public void doRace(Long competitieId) {

        System.out.println("competitieId: " + competitieId);

        Competitie competitie = competitieService.findById(competitieId);
        System.out.println("Competitie found!");

        Races races = competitie.getRaces();
        System.out.println("Got races!");

        Raceuitslag nieuweUitslag = new Raceuitslag(races);
        System.out.println("voor: " + nieuweUitslag.getId());
        System.out.println(nieuweUitslag.getRaces().getRaceResultaten().size());

        nieuweUitslag.setId(true);
        System.out.println("id set.");
        System.out.println("ID: " + nieuweUitslag.getId());
        raceuitslagRepository.save(nieuweUitslag);

        List<Coureur> genmatch = coureurService.generateF1Match();
        System.out.println("match generated.");

        for (Coureur c : genmatch) {
            System.out.println(c.getName());
        }

        coureurService.koppelCoureurAanRaceuitslag(genmatch, nieuweUitslag);
        nieuweUitslag.setRaceuitkomst(genmatch);
        System.out.println("koppeling voltooid.");
        System.out.println(nieuweUitslag.getRaceuitkomst());
        System.out.println(genmatch);

        racesService.save(races);
        System.out.println("saved race (container)");

        Raceuitslag saved = raceuitslagRepository.save(nieuweUitslag);
        System.out.println("saved uitslag.");

        competitieService.save(competitie);


        System.out.println("info na afloop:");
        System.out.println("saved raceId: " + saved.getRaces().getId());
        System.out.println("saved Id: " + saved.getId());

    }
}
