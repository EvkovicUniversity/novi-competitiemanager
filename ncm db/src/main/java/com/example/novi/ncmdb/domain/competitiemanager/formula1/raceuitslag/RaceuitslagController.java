package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RaceuitslagController {

    private final RaceuitslagService raceuitslagService;

    public RaceuitslagController(RaceuitslagService raceuitslagService){
        this.raceuitslagService = raceuitslagService;
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

//    @PutMapping("/{coureurId}/coureurs/{raceuitslagId}")
//    void assignCoureursToRaceuitslag(
//            @PathVariable Long coureurId,
//            @PathVariable Long raceuitslagId)
//    {
//        Raceuitslag raceuitslag = raceuitslagService.findById(raceuitslagId).get();
//        Coureur coureur = coureurService.findById(coureurId);
//        raceuitslag.assignCoureur(coureur);
//        coureurService.addCoureur(coureur);
//    }

    @PutMapping("/raceuitslag/{competitieId}")
    void generateRaceuitslagAddToCompetitie(
            @PathVariable Long competitieId)
    {
//        Raceuitslag raceuitslag = new Raceuitslag();
//        List<Coureur> coureurs = coureurService.generateF1Match();
//
//        for(int i = 0; i < 20; i++){
//            raceuitslag.assignCoureur(coureurs.get(i));
//        }
//        raceuitslagService.save(raceuitslag);



        // Creer een nieuwe Raceuitslag.
        // Push dit naar DB
        // Zet er inhoud in
        // Bind aan een Competitie
    }


}
