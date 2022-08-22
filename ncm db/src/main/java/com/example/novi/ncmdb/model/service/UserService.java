package com.example.novi.ncmdb.model.service;

import com.example.novi.ncmdb.model.authentication.models.User;
import com.example.novi.ncmdb.model.authentication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateGebruikersnaam(String gebruikersnaam, String nieuweGebruikersnaam) {
        User user = userRepository.findByUsername(gebruikersnaam).get();
        user.setUsername(nieuweGebruikersnaam);
        userRepository.save(user);
    }

    public void updateWachtwoord(String gebruikersnaam, CharSequence nieuwWachtwoord) {
        User user = userRepository.findByUsername(gebruikersnaam).get();
        user.setPassword(nieuwWachtwoord);
        userRepository.save(user);
    }

}
