package com.example.novi.ncmdb.controller.competitie;

import com.example.novi.ncmdb.domain.Formula1.F1Competitie;
import com.example.novi.ncmdb.service.F1CompetitieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompetitieController {

    private final F1CompetitieService f1CompetitieService;

    public CompetitieController(F1CompetitieService f1CompetitieService){
        this.f1CompetitieService = f1CompetitieService;
    }

    @CrossOrigin
    @GetMapping(path = "/formula1/competities")
    public List<F1Competitie> getCompetities(){

        return f1CompetitieService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "formula1/competities/{id}")
    public Optional<F1Competitie> getCompetitieById(@PathVariable Long id){
        return f1CompetitieService.findById(id);
    }

    @PostMapping("/formula1/competities")
    public void addCompetitie(@RequestBody F1Competitie f1Competitie){
        f1CompetitieService.addF1Competitie(f1Competitie);
    }
}
