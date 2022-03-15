package com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoureurController {

    private final CoureurService coureurService;

//    private final RaceuitslagService raceuitslagService;

    public CoureurController(CoureurService coureurService){
        this.coureurService = coureurService;
    }

    @CrossOrigin
    @GetMapping(path="/formula1/coureurs")
    public List<Coureur> getCoureurs(){

        return coureurService.findAll();
    }

//    @PutMapping("/{coureurId}/formula1/{raceuitslagId}")
//    void assignCoureursToRaceuitslag(@PathVariable Long coureurId,
//                                     @PathVariable Long raceuitslagId){
//
//    }

}
