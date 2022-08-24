package com.example.novi.ncmdb.controller.user;

import com.example.novi.ncmdb.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("changeUsername/{username}")
    public ResponseEntity<?> changeUsername(@RequestBody String nieuweGebruikersnaam, @PathVariable String username) {

        try {

            userService.updateGebruikersnaam(username, nieuweGebruikersnaam);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("changePassword/{username}")
    public ResponseEntity<?> changePassword(@RequestBody String nieuwWachtwoord, @PathVariable String username) {

        try {

            userService.updateWachtwoord(username, nieuwWachtwoord);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
