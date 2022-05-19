package com.example.novi.ncmdb.domain.competitiemanager.gebruikers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GebruikerController {

    private final GebruikerService gebruikerService;

    public GebruikerController(GebruikerService gebruikerService) {
        this.gebruikerService = gebruikerService;
    }

    @CrossOrigin
    @PutMapping(path = "gebruikers/gebruikersnaamwijzigen/{gebruikerId}/{nieuweNaam}")
    public ResponseEntity<String> veranderGebruikersnaam(@PathVariable Long gebruikerId, @PathVariable String nieuweNaam) {

        try {
            Gebruiker gebruiker = gebruikerService.findById(gebruikerId);

            gebruiker.setGebruikersnaam(nieuweNaam);

            gebruikerService.gebruikersnaamWijzigen(gebruikerId);
            gebruikerService.gebruikerToevoegen(gebruiker);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin
    @PutMapping(path = "gebruikers/wachtwoordwijzigen/{gebruikerId}/{nieuwWachtwoord}")
    public ResponseEntity<String> veranderWachtwoord(@PathVariable Long gebruikerId, @PathVariable String nieuwwachtwoord) {

        try {
            Gebruiker gebruiker = gebruikerService.findById(gebruikerId);

            gebruiker.setWachtwoord(nieuwwachtwoord);

            gebruikerService.wachtwoordWijzigen(gebruikerId);
            gebruikerService.gebruikerToevoegen(gebruiker);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin
    @PostMapping(path = "/gebruikers/toevoegen")
    public ResponseEntity<String> addGebruiker(@RequestBody Gebruiker gebruiker) {

        try {
            gebruikerService.gebruikerToevoegen(gebruiker);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}