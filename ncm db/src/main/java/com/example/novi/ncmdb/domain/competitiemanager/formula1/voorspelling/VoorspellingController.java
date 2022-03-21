package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VoorspellingController {

    private final VoorspellingService voorspellingService;

    public VoorspellingController(VoorspellingService voorspellingService){
        this.voorspellingService = voorspellingService;
    }

    @CrossOrigin
    @GetMapping(path = "http://localhost:8080/voorspelling/user/{raceuitslagId}")
    String getVoorspellingByUitslagId(@PathVariable Long raceuitslagId){
        return "Henk";
    }
}
