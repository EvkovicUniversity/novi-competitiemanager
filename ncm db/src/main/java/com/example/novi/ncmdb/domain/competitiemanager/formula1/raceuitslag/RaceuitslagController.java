package com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
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
    @GetMapping(path = "competities/raceuitslagen/{uitslagId}")
    public Iterable<Coureur> getUitkomstByUitslagId(@PathVariable Long uitslagId) {

        return raceuitslagService.findById(uitslagId).getRaceuitkomst();
    }

}
