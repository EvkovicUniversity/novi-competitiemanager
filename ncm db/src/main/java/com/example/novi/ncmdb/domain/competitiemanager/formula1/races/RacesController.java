package com.example.novi.ncmdb.domain.competitiemanager.formula1.races;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RacesController {

    private final RacesService racesService;

    public RacesController(RacesService racesService) {
        this.racesService = racesService;
    }

    @CrossOrigin
    @GetMapping(path = "races/getAll")
    Iterable<Races> getAllRaces() {
        return racesService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen/racesId/{raceId}")
    public List<Raceuitslag> getRaceuitslagIds(@PathVariable Long raceId) {
        return racesService.findById(raceId).getRaceResultaten();
    }

}
