package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoorspellingController {

    private final VoorspellingService voorspellingService;

    public VoorspellingController(VoorspellingService voorspellingService){
        this.voorspellingService = voorspellingService;
    }



    @CrossOrigin
    @GetMapping(path = "user/voorspelling/{voorspellingId}")
    Voorspelling getVoorspellingById(@PathVariable Long voorspellingId){
        return voorspellingService.findById(voorspellingId);
    }

    @CrossOrigin
    @PostMapping(path = "user/formula1/voorspelling/{}")
    public void addVoorspelling(){
//        voorspellingService.addVoorspelling();
    }
}
