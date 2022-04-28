package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CoureurController {

    private final CoureurService coureurService;

    public CoureurController(CoureurService coureurService) {
        this.coureurService = coureurService;
    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/formula1/vanillaCoureurs")
    public ResponseEntity<List<Coureur>> getVanillaCoureurs(){

        List<Coureur> coureurs = coureurService.findAll();
        List<Coureur> result = new ArrayList<>();

        for (Coureur c : coureurs){
            if (c.getRaceuitslag() == null){
                result.add(c);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
