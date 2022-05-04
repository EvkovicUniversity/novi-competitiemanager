package com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.Races;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static java.lang.Long.parseLong;

@RestController
public class CompetitieController {

    private final CompetitieService competitieService;
    private final RacesService racesService;
    private final RaceuitslagService raceuitslagService;
    private final CoureurService coureurService;

    public CompetitieController(CompetitieService competitieService, RacesService racesService, RaceuitslagService raceuitslagService, CoureurService coureurService) {
        this.competitieService = competitieService;
        this.racesService = racesService;
        this.raceuitslagService = raceuitslagService;
        this.coureurService = coureurService;
    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/formula1/competities")
    public ResponseEntity<List<Competitie>> getCompetities() {

        return new ResponseEntity<>(competitieService.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/competities/raceuitslagen/raceId/{competitieId}")
    public ResponseEntity<Long> getRaceId(@PathVariable String competitieId) {

        try {
            Long competitieIdLong = parseLong(competitieId);
            return new ResponseEntity<>(competitieService.findById(competitieIdLong).getRaces().getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @GetMapping(path = "/competitiemanager/formula1/competities/{id}")
    public ResponseEntity<Competitie> getCompetitieById(@PathVariable String id) {

        try {
            Long idLong = parseLong(id);
            return new ResponseEntity<>(competitieService.findById(idLong), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @CrossOrigin
    @PostMapping(path = "/competitiemanager/formula1/competities")
    public void save(@RequestBody Competitie competitie) {
        //Sla competitie op met gegeven naam
        Competitie savedCompetitie = competitieService.save(new Competitie(competitie.getCompetitienaam()));

        //Maak races aan gekoppeld aan competitie
        Races races = new Races(savedCompetitie);

        //Sla races op
        Races savedRaces = racesService.save(races);

        //Koppel races aan competitie
        savedCompetitie.setRaces(savedRaces);
        competitieService.save(savedCompetitie);

        Raceuitslag raceuitslag = new Raceuitslag(savedRaces);
        raceuitslag.setId(false);




//        //Maak competitie
//        Competitie competitiecontainer = new Competitie(competitie.getCompetitienaam());
//
//        //Maak racecontainer
//        Races racecontainer = new Races(competitiecontainer);
//
//        //Maak raceuitslagcontainers & bind raceuitslag aan racecontainer
//        Raceuitslag uitslagcontainer = new Raceuitslag(racecontainer);
//
//        racesService.save(racecontainer);
//        raceuitslagService.save(uitslagcontainer);
//
//        //Genereer uitkomst
//        List<Coureur> gegenereerdeUitkomst = coureurService.generateF1Match();
//        List<Coureur> nieuweCoureurobjecten =
//                coureurService.geefLijstCoureursMetEindpositieGekoppeldAanRaceuitslag(
//                        gegenereerdeUitkomst,
//                        uitslagcontainer
//                );
//        coureurService.saveAll(nieuweCoureurobjecten);
//
//        // Zet raceuitslagen in lijst
//        List<Raceuitslag> raceuitslag = Arrays.asList(uitslagcontainer);
//        //Koppel de uitslagen aan de racecontainer
//        racecontainer.setRaceResultaten(raceuitslag);
//
//        //koppel racecontainer aan competitie
//        competitiecontainer.setRaces(racecontainer);
//
////        // sla op in DB
//        competitieService.save(competitiecontainer);
//
//        System.out.println("Done!");

    }

}
