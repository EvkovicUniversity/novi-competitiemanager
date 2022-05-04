package com.example.novi.ncmdb.domain.competitiemanager.formula1.races;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.Raceuitslag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(path = "/competitiemanager/formula1")
public class RacesController {

    private final RacesService racesService;

    public RacesController(RacesService racesService) {
        this.racesService = racesService;
    }

    @CrossOrigin
    @GetMapping(path = "/races/getAll")
    Iterable<Races> getAllRaces() {
        return racesService.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen/racesId/{raceId}")
    public ResponseEntity<List<Raceuitslag>> getRaceuitslagIds(@PathVariable String raceId) {

        if (raceId != null && !raceId.equals("undefined")){
            Long raceIdLong = parseLong(raceId);
            return new ResponseEntity<>(racesService.findById(raceIdLong).getRaceResultaten(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
