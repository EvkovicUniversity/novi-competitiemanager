package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

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
    @GetMapping(path = "competities/raceuitslagen/{racesId}")
    public Iterable<Raceuitslag> getRaceuitslagenByRacesId(@PathVariable Long racesId){

        return null;
    }

}
