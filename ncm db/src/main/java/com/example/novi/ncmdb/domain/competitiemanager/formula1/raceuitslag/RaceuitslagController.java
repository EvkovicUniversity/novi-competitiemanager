package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.Voorspelling;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.VoorspellingController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
public class RaceuitslagController {

    private final RaceuitslagService raceuitslagService;
    private final VoorspellingController voorspellingController;

    public RaceuitslagController(RaceuitslagService raceuitslagService, VoorspellingController voorspellingController) {
        this.raceuitslagService = raceuitslagService;
        this.voorspellingController = voorspellingController;
    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/competities/raceuitslagen")
    public ResponseEntity<List<Raceuitslag>> getRaceuitslagen() {
        return new ResponseEntity<>(raceuitslagService.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/competities/raceuitslagen/{uitslagId}")
    public ResponseEntity<Iterable<Coureur>> getUitkomstByUitslagId(@PathVariable String uitslagId) {

        try {
            return new ResponseEntity<>(raceuitslagService.findById(uitslagId).getRaceuitkomst(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/user/voorspelling/raceuitslag/{raceuitslagId}")
    ResponseEntity<Iterable<Voorspelling>> getVoorspellingenByRaceuitslag(@PathVariable String raceuitslagId){

        try {
            return new ResponseEntity<>(raceuitslagService.findById(raceuitslagId).getVoorspellingen(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @PostMapping(path = "/competitiemanager/formula1/playmatch/{competitieId}")
    public void doRace(@PathVariable String competitieId){

        System.out.println("match played");

        try {
            Long competitieIdLong = parseLong(competitieId);
            raceuitslagService.doRace(competitieIdLong);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
