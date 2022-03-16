package com.example.novi.ncmdb.domain.competitiemanager.competitie;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompetitieController {

    private final CompetitieService competitieService;
    private final RaceuitslagService raceuitslagService;

    public CompetitieController(CompetitieService competitieService, RaceuitslagService raceuitslagService){
        this.competitieService = competitieService;
        this.raceuitslagService = raceuitslagService;
    }

    @CrossOrigin
    @GetMapping(path = "/formula1/competities")
    public List<Competitie> getCompetities(){
        return competitieService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/formula1/competities/{id}")
    public Optional<Competitie> getCompetitieById(@PathVariable Long id){
        return competitieService.findById(id);
    }

    @CrossOrigin
    @PostMapping(path = "/formula1/competities")
    public void addCompetities(@RequestBody Competitie competitie){
        competitieService.addCompetitie(competitie);
    }

    @CrossOrigin
    @PutMapping("/{raceId}/competities/{competitieId}")
    void assignRaceToCompetitie(@PathVariable Long raceId,
                                @PathVariable Long competitieId){
        Raceuitslag raceuitslag = raceuitslagService.findById(raceId).get();
        Competitie competitie = competitieService.findById(competitieId).get();
        raceuitslag.assignCompetitie(competitie);
        raceuitslagService.save(raceuitslag);
    }
}
