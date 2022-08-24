package com.example.novi.ncmdb.service.user;

import com.example.novi.ncmdb.model.user.User;
import com.example.novi.ncmdb.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateGebruikersnaam(String gebruikersnaam, String nieuweGebruikersnaam) {
        nieuweGebruikersnaam = removeNonsense(nieuweGebruikersnaam);
        nieuweGebruikersnaam = nieuweGebruikersnaam.toLowerCase();

        User user = userRepository.findByUsername(gebruikersnaam).get();
        user.setUsername(nieuweGebruikersnaam);
        userRepository.save(user);
    }

    public void updateWachtwoord(String gebruikersnaam, String nieuwWachtwoord) {
        nieuwWachtwoord = removeNonsense(nieuwWachtwoord);

        User user = userRepository.findByUsername(gebruikersnaam).get();
        user.setPassword(nieuwWachtwoord);
        userRepository.save(user);
    }

    private String removeNonsense(String input) {
        String output = input.replace("\"", "");
        output = output.replace("[", "");
        output = output.replace("]", "");

        return output;
    }
}
