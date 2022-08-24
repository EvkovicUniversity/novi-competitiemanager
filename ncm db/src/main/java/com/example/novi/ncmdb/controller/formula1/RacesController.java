package com.example.novi.ncmdb.controller.formula1;

import com.example.novi.ncmdb.model.formula1.Races;
import com.example.novi.ncmdb.model.formula1.Raceuitslag;
import com.example.novi.ncmdb.service.formula1.RacesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(path = "/competitiemanager/formula1")
public class RacesController {

    private final RacesService service;

    public RacesController(RacesService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping(path = "/races/getAll")
    Iterable<Races> getAllRaces() {
        return service.findAll();
    }

    @CrossOrigin
    @GetMapping(path = "/competities/raceuitslagen/racesId/{raceId}")
    public ResponseEntity<List<Raceuitslag>> getRaceuitslagIds(@PathVariable String raceId) {

        if (raceId != null && !raceId.equals("undefined")) {
            Long raceIdLong = parseLong(raceId);
            return new ResponseEntity<>(service.findById(raceIdLong).getRaceResultaten(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
