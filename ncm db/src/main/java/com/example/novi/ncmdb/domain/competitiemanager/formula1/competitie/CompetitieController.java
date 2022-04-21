package com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
public class CompetitieController {

    private final CompetitieService competitieService;

    public CompetitieController(CompetitieService competitieService) {
        this.competitieService = competitieService;
    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/formula1/competities")
    public List<Competitie> getCompetities() {
        return competitieService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/competities/raceuitslagen/raceId/{competitieId}")
    public ResponseEntity<Long> getRaceId(@PathVariable String competitieId){

        if (competitieId != null && !competitieId.equals("undefined")){

            try {
                Long competitieIdLong = parseLong(competitieId);
                return new ResponseEntity<>(competitieService.findById(competitieIdLong).getRaces().getId(), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//    @CrossOrigin
//    @GetMapping(path = "/competitiemanager/competities/raceuitslagen/raceId/{competitieId}")
//    public Long getRaceId(@PathVariable String competitieId){
//
//        if (competitieId != null && !competitieId.equals("undefined")){
//            Long competitieIdLong = parseLong(competitieId);
//
//            return competitieService.findById(competitieIdLong).getRaces().getId();
//        }
//        return null;
//    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/formula1/competities/{id}")
    public Competitie getCompetitieById(@PathVariable String id) {

        if (id != null && !id.equals("undefined")){
            Long idLong = parseLong(id);
            return competitieService.findById(idLong);
        }
        return null;
    }

    @CrossOrigin
    @PostMapping(path = "/competitiemanager/formula1/competities")
    public void addCompetities(@RequestBody Competitie competitie) {
        competitieService.addCompetitie(competitie);
    }

}
