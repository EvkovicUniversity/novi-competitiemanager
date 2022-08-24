package com.example.novi.ncmdb.controller.formula1;

import com.example.novi.ncmdb.model.formula1.Coureur;
import com.example.novi.ncmdb.service.formula1.CoureurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/competitiemanager/formula1")
public class CoureurController {

    private final CoureurService coureurService;

    public CoureurController(CoureurService coureurService) {
        this.coureurService = coureurService;
    }

    @CrossOrigin
    @GetMapping(path = "/vanillaCoureurs")
    public ResponseEntity<List<Coureur>> getVanillaCoureurs() {

        List<Coureur> coureurs = coureurService.findAll();
        List<Coureur> result = new ArrayList<>();

        for (Coureur c : coureurs) {
            if (c.getRaceuitslag() == null) {
                result.add(c);
            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
