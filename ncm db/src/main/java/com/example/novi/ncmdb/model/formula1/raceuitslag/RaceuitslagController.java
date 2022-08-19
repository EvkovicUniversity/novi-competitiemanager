package com.example.novi.ncmdb.model.formula1.raceuitslag;

import com.example.novi.ncmdb.model.formula1.coureur.Coureur;
import com.example.novi.ncmdb.model.formula1.voorspelling.Voorspelling;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(path = "/competitiemanager/formula1")
public class RaceuitslagController {

    private final RaceuitslagService service;

    public RaceuitslagController(RaceuitslagService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen")
    public ResponseEntity<List<Raceuitslag>> getRaceuitslagen() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen/{uitslagId}")
    public ResponseEntity<Iterable<Coureur>> getUitkomstByUitslagId(@PathVariable String uitslagId) {

        try {
            return new ResponseEntity<>(service.findById(uitslagId).getRaceuitkomst(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @GetMapping(path = "/user/voorspelling/raceuitslag/{raceuitslagId}")
    public ResponseEntity<List<Voorspelling>> getVoorspellingenByRaceuitslag(@PathVariable String raceuitslagId){

        try {
            return new ResponseEntity<>(service.findById(raceuitslagId).getVoorspellingen(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @PostMapping(path = "/playmatch/{competitieId}")
    public void doRace(@PathVariable String competitieId){

        try {
            Long competitieIdLong = parseLong(competitieId);
            service.doRace(competitieIdLong);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
