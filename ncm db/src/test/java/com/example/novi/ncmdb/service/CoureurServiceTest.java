package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CoureurServiceTest {

    private CoureurService sut;
    private CoureurRepository coureurRepository;

    @BeforeEach
    void init(){
        sut = new CoureurService(coureurRepository);
    }

//    @Test
//    void generateF1MatchTest(){
//        List<Coureur> raceUitslag;
//
//        raceUitslag = sut.generateF1Match();
//
//        for (int index = 0; index < 20; index++){
//            System.out.println(index+1 + "e plek: " + raceUitslag.get(index).getName());
//        }
//    }


    @Test
    void name() {
        String test = "TestNoppes";
        char[] space = " ".toCharArray();

        char capitol = test.charAt(4);
        boolean isCapitol = false;
        if (Character.isUpperCase(capitol)){
            isCapitol = true;
        }

        System.out.println(isCapitol);

        System.out.println("CHAR ADDED: " + addChar(test, space[0], 4));
    }

    String addChar(String str, char ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        return sb.toString();
    }
}
