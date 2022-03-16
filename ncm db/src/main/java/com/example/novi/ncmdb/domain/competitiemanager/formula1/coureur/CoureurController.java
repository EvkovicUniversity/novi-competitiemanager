package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoureurController {

    private final CoureurService coureurService;

    public CoureurController(CoureurService coureurService) {
        this.coureurService = coureurService;
    }

    @CrossOrigin
    @GetMapping(path = "/formula1/coureurs")
    public List<Coureur> getCoureurs() {

        return coureurService.findAll();
    }

}
