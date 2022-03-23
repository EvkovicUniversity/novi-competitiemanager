package com.example.novi.ncmdb.domain.authenticatie.gebruiker;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GebruikerService {

    private final GebruikerRepository gebruikerRepository;

    private final PasswordEncoder passwordEncoder;

    public GebruikerService(GebruikerRepository gebruikerRepository){
        this.gebruikerRepository = gebruikerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Gebruiker findById(Long gebruikerId){
        return gebruikerRepository.findById(gebruikerId).get();
    }

    public void wijzigGebruikersnaam(Long gebruikerId, String nieuweNaam) {
        Gebruiker gebruiker = this.gebruikerRepository.findById(gebruikerId).get();
        gebruiker.setGebruikersnaam(nieuweNaam);

        gebruikerToevoegen(gebruiker);
    }

    public void wijzigWachtwoord(Long gebruikerId, String nieuwwachtwoord) {
        Gebruiker gebruiker = this.gebruikerRepository.findById(gebruikerId).get();
        gebruiker.setWachtwoord(nieuwwachtwoord);

        gebruikerToevoegen(gebruiker);
    }

    public void gebruikerToevoegen(Gebruiker gebruiker){
        String encodedPassword = this.passwordEncoder.encode(gebruiker.getWachtwoord());
        gebruiker.setWachtwoord(encodedPassword);
        gebruikerRepository.save(gebruiker);
    }
}
