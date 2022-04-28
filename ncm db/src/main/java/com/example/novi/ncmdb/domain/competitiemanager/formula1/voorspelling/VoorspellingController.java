package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static java.lang.Long.parseLong;

@RestController
public class VoorspellingController {

    private final VoorspellingService voorspellingService;

    public VoorspellingController(VoorspellingService voorspellingService) {
        this.voorspellingService = voorspellingService;
    }


    @CrossOrigin
    @GetMapping(path = "/competitiemanager/user/voorspelling/{voorspellingId}")
    ResponseEntity<Voorspelling> getVoorspellingById(@PathVariable String voorspellingId) {

        try {
            Long voorspellingIdLong = parseLong(voorspellingId);
            return new ResponseEntity<>(voorspellingService.findById(voorspellingIdLong), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void saveVoorspelling(Voorspelling voorspelling){
        this.voorspellingService.save(voorspelling);
    }

    @CrossOrigin
    @PostMapping(
            path = "/competitiemanager/user/formula1/voorspelling",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> addVoorspelling(@RequestBody String voorspelling) {
//        saveVoorspelling(voorspelling);

        System.out.println(voorspelling);

        return ResponseEntity.created(URI.create(String.format("/voorspellingen/%s", 4)))
                .body(voorspelling);
    }
}
