package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.Voorspelling;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
public class RaceuitslagController {

    private final RaceuitslagService raceuitslagService;

    public RaceuitslagController(RaceuitslagService raceuitslagService) {
        this.raceuitslagService = raceuitslagService;
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen")
    public List<Raceuitslag> getRaceuitslagen() {
        return raceuitslagService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen/{uitslagId}")
    public Iterable<Coureur> getUitkomstByUitslagId(@PathVariable String uitslagId) {

        if (uitslagId != null && !uitslagId.equals("undefined")){
            Long uitslagIdLong = parseLong(uitslagId);
            return raceuitslagService.findById(uitslagIdLong).getRaceuitkomst();
        }

        return null;
    }

    @CrossOrigin
    @GetMapping(path = "user/voorspelling/raceuitslag/{raceuitslagId}")
    Iterable<Voorspelling> getVoorspellingenByRaceuitslag(@PathVariable String raceuitslagId){

        if (raceuitslagId != null && !raceuitslagId.equals("undefined")){
            Long raceuitslagIdLong = parseLong(raceuitslagId);
            return raceuitslagService.findById(raceuitslagIdLong).getVoorspellingen();
        }

        return null;
    }

    @CrossOrigin
    @PostMapping(path = "formula1/playmatch/{competitieId}")
    public void doRace(@PathVariable String competitieId){

        if (competitieId != null && !competitieId.equals("undefined")){
            Long competitieIdLong = parseLong(competitieId);
            raceuitslagService.doRace(competitieIdLong);
        }

    }

}
