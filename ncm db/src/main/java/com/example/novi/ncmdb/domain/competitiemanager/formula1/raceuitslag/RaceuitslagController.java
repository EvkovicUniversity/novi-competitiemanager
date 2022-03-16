package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaceuitslagController {

    private final RaceuitslagService raceuitslagService;
    private final CoureurService coureurService;

    public RaceuitslagController(RaceuitslagService raceuitslagService, CoureurService coureurService){
        this.raceuitslagService = raceuitslagService;
        this.coureurService = coureurService;
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen")
    public List<Raceuitslag> getRaceuitslagen(){
        return raceuitslagService.findAll();
    }

    @CrossOrigin
    @PostMapping(path = "/competities/raceuitslagen")
    public void addRaceuitslag(@RequestBody Raceuitslag raceuitslag){
        raceuitslagService.save(raceuitslag);
    }

    @PutMapping("/{coureurId}/coureurs/{raceuitslagId}")
    void assignCoureursToRaceuitslag(
            @PathVariable Long coureurId,
            @PathVariable Long raceuitslagId)
    {
        Raceuitslag raceuitslag = raceuitslagService.findById(raceuitslagId).get();
        Coureur coureur = coureurService.findById(coureurId);
        raceuitslag.assignCoureur(coureur);
        coureurService.addCoureur(coureur);
    }

    @PutMapping("/raceuitslag/{competitieId}")
    void generateRaceuitslagAddToCompetitie(
            @PathVariable Long competitieId)
    {
        Raceuitslag raceuitslag = new Raceuitslag();
        List<Coureur> coureurs = coureurService.generateF1Match();

        for(Coureur c : coureurs){
            raceuitslag.assignCoureur(c);
        }
        raceuitslagService.save(raceuitslag);
    }
}
