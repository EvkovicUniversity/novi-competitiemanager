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
        Competitie competitie = competitieService.findById(competitieId);
        Races races = competitie.getRaces();

        //Eerst kijken of er een voorspelling gedaan is. Zo ja, dan bestaat het object Raceuitslag al.
        int index = races.getRaceResultaten().size();
        System.out.println("size: " + index);
        Raceuitslag laatsteRace = races.getRaceResultaten().get(index-1);
        System.out.println("laatste race: " + laatsteRace.getId());


        if (!laatsteRace.isPlayed()) {

            System.out.println("laatste race is niet played.");
            List<Coureur> genmatch = coureurService.generateF1Match();
            coureurService.koppelCoureurAanRaceuitslag(genmatch, laatsteRace);
            laatsteRace.setRaceuitkomst(genmatch);

            laatsteRace.setPlayed();
            raceuitslagRepository.save(laatsteRace);
        } else {

            Raceuitslag nieuweUitslag = new Raceuitslag(races);
            System.out.println(nieuweUitslag.getRaces().getRaceResultaten().size());

            nieuweUitslag.setId(false);
            raceuitslagRepository.save(nieuweUitslag);

            List<Coureur> genmatch = coureurService.generateF1Match();

            coureurService.koppelCoureurAanRaceuitslag(genmatch, nieuweUitslag);
            nieuweUitslag.setRaceuitkomst(genmatch);

            racesService.save(races);
            raceuitslagRepository.save(nieuweUitslag);
            competitieService.save(competitie);

        }
    }
}
