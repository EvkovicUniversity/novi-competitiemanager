package com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Long.parseLong;

@RestController
public class VoorspellingController {

    private final VoorspellingService voorspellingService;
    private final CompetitieService competitieService;

    public VoorspellingController(VoorspellingService voorspellingService, CompetitieService competitieService) {
        this.voorspellingService = voorspellingService;
        this.competitieService = competitieService;
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

    public void save(Voorspelling voorspelling) {
        this.voorspellingService.save(voorspelling);
    }

    @CrossOrigin
    @PostMapping(
            path = "/competitiemanager/user/formula1/voorspelling/{competitieId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> addVoorspelling(@PathVariable String competitieId, @RequestBody String voorspelling) {


        String nummerRegex = "[0-9]";
        String nonletter = "[^a-zA-Z0-9_]";

        List<String> eindlijst = new ArrayList<>();
        String modified = voorspelling.replaceAll(nonletter, "");
//        System.out.println("1e: " + modified);
        modified = modified.replaceAll("postdata", "");
//        System.out.println("2e: " + modified);
        char[] array = modified.toCharArray();

        String eindpositie = "";
        String naam = "";
        List<String> naamlijst = new ArrayList<>();
        boolean doubleDigit = false;


        for (Character c : array) {


            if (c.toString().matches(nummerRegex)){

                if (naam.length() > 0) {
                    naamlijst.add(naam);
                    naam = "";
                }

                if (doubleDigit) {
                    eindpositie = eindpositie.concat(c.toString());
                    eindlijst.add(eindpositie);
                    eindpositie = "";
                    doubleDigit = false;
                }

                eindpositie = eindpositie.concat(c.toString());
                doubleDigit = true;
            }
            else {
                doubleDigit = false;

                if (eindpositie.length() > 0) {
                    eindlijst.add(eindpositie);
                    eindpositie = "";
                }
                naam = naam.concat(c.toString());
            }
        }

        Set<String> set = new LinkedHashSet<>(eindlijst);
        eindlijst.clear();
        eindlijst.addAll(set);

        eindlijst.remove("0");


        HashMap<String, String> combined = new HashMap<>();
        for (int i = 0;i < eindlijst.size() ;i++) {
            combined.put(eindlijst.get(i), naamlijst.get(i));
        }

        System.out.println("HashMap: ");
        for (String s : combined.keySet()) {
            System.out.println(combined.get(s) + combined.keySet());
        }





        System.out.println("Posities:");
        for (String s : eindlijst) {
            System.out.println(s);
        }

        System.out.println("Namen:");
        for (String s : naamlijst) {
            System.out.println(s);
        }



//        String nonletter = "[^a-zA-Z0-9_]";
//        String nummer = "[0-9]";
//        String mutilated;
//        String naam = "";
//        String eindpositie = "";
//        boolean previousWasNumber = false;
//
//        List<String> naamLijst = new ArrayList<>();
//        List<String> eindpositieLijst = new ArrayList<>();
//
//        mutilated = voorspelling.replaceAll(nonletter, "");
//        char[] carray = mutilated.toCharArray();
//
//        for (Character c : carray) {
//            String karakter = c.toString();
//
//            if (karakter.matches(nummer)) {
//
//                if (previousWasNumber) {
//                    eindpositie = eindpositie.concat(karakter);
//                    eindpositieLijst.add(eindpositie);
//                    eindpositie = "";
//
//                    previousWasNumber = false;
//                    break;
//                }
//
//                eindpositie = eindpositie.concat(karakter);
//                previousWasNumber = true;
//
//            } else {
//                if (previousWasNumber && !karakter.matches(nummer)) {
//                    eindpositieLijst.add(eindpositie);
//                    eindpositie = "";
//                }
//                previousWasNumber = false;
//            }


//        }

//        System.out.println(eindpositieLijst.size());

//        for (String s : eindpositieLijst){
//            System.out.println(s);
//        }

        return ResponseEntity.created(URI.create(String.format("/voorspellingen/%s", 4)))
                .body(voorspelling);

    }
}
