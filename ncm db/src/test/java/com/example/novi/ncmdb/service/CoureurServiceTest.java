package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.Coureur;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class CoureurServiceTest {

    private CoureurService sut;
    private CoureurRepository coureurRepository;

    @BeforeEach
    void init(){
        sut = new CoureurService(coureurRepository);
    }

    @Test
    void generateF1MatchTest(){
        List<Coureur> raceUitslag;

        raceUitslag = sut.generateF1Match();

        for (int index = 0; index < 20; index++){
            System.out.println(index+1 + "e plek: " + raceUitslag.get(index).getName());
        }
    }


    @Test
    void freelanceTest() {
        String input = "[\n" +
                "{ \n"
                + "Alexander Albon"+":"+ "1"+",\n"
                + "Fernando Alonso"+":"+ "2"+",\n"
                + "Valtteri Bottas"+":"+ "3"+",\n"
                + "Pierre Gasly"+":"+ "4"+",\n"
                + "Lewis Hamilton"+":"+ "5"+",\n"
                + "Nicholas Latifi"+":"+ "6"+",\n"
                + "Charles Leclerc"+":"+ "7"+",\n"
                + "Nikita Mazepin"+":"+ "8"+",\n"
                + "Lando Norris"+":"+ "9"+",\n"
                + "Esteban Ocon"+":"+ "10"+",\n"
                + "Sergio Pérez"+":"+ "11"+",\n"
                + "Daniel Ricciardo"+":"+ "12"+",\n"
                + "George Russell"+":"+ "13"+",\n"
                + "Carlos Sainz jr."+":"+ "14"+",\n"
                + "Mick Schumacher"+":"+ "15"+",\n"
                + "Yuki Tsunoda"+":"+ "16"+",\n"
                + "Lance Stroll"+":"+ "17"+",\n"
                + "Max Verstappen"+":"+ "18"+"\n,"
                + "Sebastian Vettel"+":"+ "19"+",\n"
                + "Guanyu Zhou"+":"+ "20"+",\n"
        +"}\n"
                + "]";

        List<String> alleNummers = new ArrayList<>();

//        alleNummers = gimme(input);
            gimme(input);
//        for (String s : alleNummers) {
//            System.out.println(s);
//        }
    }

//    private List<String> gimme(String input) {
    private void gimme(String input) {
        String nummerRegex = "[0-9]";
        String nonletter = "[^a-zA-Z0-9_]";

        List<String> eindlijst = new ArrayList<>();
        String modified = input.replaceAll(nonletter, "");
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

    }

}
