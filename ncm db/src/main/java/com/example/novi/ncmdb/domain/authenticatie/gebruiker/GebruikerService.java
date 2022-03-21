package com.example.novi.ncmdb.domain.authenticatie.gebruiker;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class GebruikerService {

    private final GebruikerRepository gebruikerRepository;

    private PasswordEncoder passwordEncoder;

    public GebruikerService(GebruikerRepository gebruikerRepository){
        this.gebruikerRepository = gebruikerRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Gebruiker findById(Long gebruikerId){
        return gebruikerRepository.findById(gebruikerId).get();
    }

    public void gebruikersnaamWijzigen(Long gebruikerId) {

    }

    public void wachtwoordWijzigen(Long gebruikerId) {

    }

    public Gebruiker gebruikerToevoegen(Gebruiker gebruiker){
        String encodedPassword = this.passwordEncoder.encode(gebruiker.getWachtwoord());
        gebruiker.setWachtwoord(encodedPassword);
        return gebruikerRepository.save(gebruiker);
    }

}
