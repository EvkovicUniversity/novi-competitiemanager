package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.springframework.web.bind.annotation.*;

import static java.lang.Long.parseLong;

@RestController
public class VoorspellingController {

    private final VoorspellingService voorspellingService;

    public VoorspellingController(VoorspellingService voorspellingService) {
        this.voorspellingService = voorspellingService;
    }


    @CrossOrigin
    @GetMapping(path = "/competitiemanager/user/voorspelling/{voorspellingId}")
    Voorspelling getVoorspellingById(@PathVariable String voorspellingId) {

        if (voorspellingId != null && !voorspellingId.equals("undefined")) {
            Long voorspellingIdLong = parseLong(voorspellingId);
            return voorspellingService.findById(voorspellingIdLong);
        }

        return null;
    }

    @CrossOrigin
    @PostMapping(path = "/competitiemanager/user/formula1/voorspelling/{}")
    public void addVoorspelling() {
//        voorspellingService.addVoorspelling();
    }
}
