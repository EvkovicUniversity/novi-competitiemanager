package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import org.hibernate.boot.jaxb.hbm.internal.CacheAccessTypeConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.net.URI;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping(path = "/competitiemanager/formula1")
public class VoorspellingController {

    private final VoorspellingService service;

    public VoorspellingController(VoorspellingService voorspellingService) {
        this.service = voorspellingService;
    }

    @CrossOrigin
    @GetMapping(path = "/user/voorspelling/{voorspellingId}")
    ResponseEntity<Voorspelling> getVoorspellingById(@PathVariable String voorspellingId) {

        try {
            Long voorspellingIdLong = parseLong(voorspellingId);
            return new ResponseEntity<>(service.findById(voorspellingIdLong), HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @PostMapping(
            path = "/user/formula1/voorspelling/{competitieId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> addVoorspelling(@RequestBody String jsonbody) {

        try {
            service.addVoorspelling(jsonbody);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }

        return ResponseEntity.created(URI.create(String.format("/voorspellingen/%s", 4)))
                .body(jsonbody);
    }

}
