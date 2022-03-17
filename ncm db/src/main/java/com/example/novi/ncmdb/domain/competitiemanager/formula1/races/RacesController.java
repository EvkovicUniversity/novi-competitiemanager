package com.example.novi.ncmdb.domain.competitiemanager.formula1.races;

import com.example.novi.ncmdb.domain.competitiemanager.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.competitie.CompetitieService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RacesController {

    private final RacesService racesService;
    private final RaceuitslagService raceuitslagService;
    private final CompetitieService competitieService;

    public RacesController(RacesService racesService, RaceuitslagService raceuitslagService, CompetitieService competitieService) {
        this.racesService = racesService;
        this.raceuitslagService = raceuitslagService;
        this.competitieService = competitieService;
    }

    @CrossOrigin
    @GetMapping(path = "races/getAll")
    Iterable<Races> getAllRaces(){
        return racesService.findAll();
    }

    @PutMapping("/put/raceuitslag/into/race/{raceuitslag_id}/{race_id}")
    void assignUitslagToRace(
            @PathVariable Long raceuitslag_id,
            @PathVariable Long race_id
    ){
        Raceuitslag raceuitslag = raceuitslagService.findById(raceuitslag_id);
        Races races = racesService.findById(race_id);
        raceuitslag.setRaces(races);
        racesService.save(races);
    }

    @CrossOrigin
    @PutMapping(path = "/races/competitie/{races_id}/{competitie_id}")
    void assignRacesToCompetitie(
            @PathVariable Long races_id,
            @PathVariable Long competitie_id
    ){
        Competitie competitie = competitieService.findById(competitie_id);
        Races races = racesService.findById(races_id);
        races.setCompetitie(competitie);
        racesService.save(races);
    }
}
