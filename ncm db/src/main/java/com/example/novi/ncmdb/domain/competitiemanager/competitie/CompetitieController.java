package com.example.novi.ncmdb.domain.competitiemanager.competitie;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompetitieController {

    private final CompetitieService competitieService;

    public CompetitieController(CompetitieService competitieService){
        this.competitieService = competitieService;
    }

    @CrossOrigin
    @GetMapping(path = "/formula1/competities")
    public List<Competitie> getCompetities(){
        return competitieService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/formula1/competities/{id}")
    public Competitie getCompetitieById(@PathVariable Long id){
        return competitieService.findById(id);
    }

    @CrossOrigin
    @PostMapping(path = "/formula1/competities")
    public void addCompetities(@RequestBody Competitie competitie){
        competitieService.addCompetitie(competitie);
    }
//
//    @CrossOrigin
//    @PutMapping("/{raceId}/competities/{competitieId}")
//    void assignRaceuitslagToCompetitie(@PathVariable Long raceId,
//                                       @PathVariable Long competitieId){
//
//        Raceuitslag raceuitslag = raceuitslagService.findById(raceId).get();
//        Competitie competitie = competitieService.findById(competitieId).get();
//        raceuitslag.assignCompetitie(competitie);
//        raceuitslagService.save(raceuitslag);
//    }

//    @CrossOrigin
//    @PutMapping("/{racesId}/competities/{competitieId}")
//    void assignRaceToCompetitie(@PathVariable Long racesId,
//                                @PathVariable Long competitieId){
//        Races races = racesService.findById(racesId);
//        Competitie competitie = competitieService.findById(competitieId).get();
//        races.assignRaceResultaten(competitie);
//        raceuitslagService.save(raceuitslag);
//    }
}
