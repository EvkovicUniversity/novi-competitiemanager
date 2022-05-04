package com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(path = "/competitiemanager/formula1")
public class CompetitieController {

    private final CompetitieService service;

    public CompetitieController(CompetitieService competitieService) {
        this.service = competitieService;
    }

    @CrossOrigin
    @GetMapping(path = "/competities")
    public ResponseEntity<List<Competitie>> getCompetities() {

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen/raceId/{competitieId}")
    public ResponseEntity<Long> getRaceId(@PathVariable String competitieId) {

        try {
            Long competitieIdLong = parseLong(competitieId);
            return new ResponseEntity<>(service.findById(competitieIdLong).getRaces().getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @GetMapping(path = "/competities/{id}")
    public ResponseEntity<Competitie> getCompetitieById(@PathVariable String id) {

        try {
            Long idLong = parseLong(id);
            return new ResponseEntity<>(service.findById(idLong), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @PostMapping(path = "/competities")
    public ResponseEntity<Competitie> addCompetitie(@RequestBody Competitie competitie) {

        service.addCompetitie(competitie);

        return ResponseEntity.created(URI.create(String.format("/voorspellingen/%s", 4)))
                .body(competitie);
    }

}
