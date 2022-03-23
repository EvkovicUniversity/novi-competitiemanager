package com.example.novi.ncmdb.domain.authenticatie.gebruiker;

import org.springframework.web.bind.annotation.*;

@RestController
public class GebruikerController {

    private final GebruikerService gebruikerService;

    public GebruikerController(GebruikerService gebruikerService){
        this.gebruikerService = gebruikerService;
    }

    @CrossOrigin
    @PutMapping(path = "gebruikers/gebruikersnaamwijzigen/{gebruikerId}/{nieuweNaam}")
    public void veranderGebruikersnaam(@PathVariable Long gebruikerId, @PathVariable String nieuweNaam){
        gebruikerService.wijzigGebruikersnaam(gebruikerId, nieuweNaam);
    }

    @CrossOrigin
    @PutMapping(path = "gebruikers/wachtwoordwijzigen/{gebruikerId}/{nieuwwachtwoord}")
    public void veranderWachtwoord(@PathVariable Long gebruikerId, @PathVariable String nieuwwachtwoord){
        gebruikerService.wijzigWachtwoord(gebruikerId, nieuwwachtwoord);

    }

    @CrossOrigin
    @PostMapping(path = "/gebruikers/toevoegen")
    public void addGebruiker(@RequestBody Gebruiker gebruiker){
        gebruikerService.gebruikerToevoegen(gebruiker);
    }

}
