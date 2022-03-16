package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
