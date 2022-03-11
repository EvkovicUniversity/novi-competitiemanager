package com.example.novi.ncmdb.service;

import com.example.novi.ncmdb.domain.Formula1.Coureur;
import com.example.novi.ncmdb.repository.f1repositories.CoureurRepository;
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
    public void findAllTest() {
        sut.findAll();
    }

    @Test
    void generateF1MatchTest(){

        List<Coureur> raceUitslag;

        raceUitslag = sut.generateF1Match();

        for (int index = 0; index < 20; index++){
            System.out.println(index+1 + "e plek: " + raceUitslag.get(index).getName());
        }
    }

}
