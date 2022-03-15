package com.example.novi.ncmdb.domain.competitiemanager.competitie;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Competitie> getCompetitieById(@PathVariable Long id){
        return competitieService.findById(id);
    }

    @CrossOrigin
    @PostMapping(path = "/formula1/competities")
    public void addCompetities(@RequestBody Competitie competitie){
        competitieService.addCompetitie(competitie);
    }

}
