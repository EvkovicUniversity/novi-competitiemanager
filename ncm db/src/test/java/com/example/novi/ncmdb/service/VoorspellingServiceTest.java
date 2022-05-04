//package com.example.novi.ncmdb.service;
//
//import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.VoorspellingRepository;
//import com.example.novi.ncmdb.domain.competitiemanager.formula1.voorspelling.VoorspellingService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class VoorspellingServiceTest {
//
//    private VoorspellingService sut;
//    private VoorspellingRepository voorspellingRepository;
//
//    private String actual;
//    private String expected;
//    private final String jsoninput = "{\n" +
//            "    \"Max Verstappen\":\"1\"\n" +
//            "}";
//
//    @BeforeEach
//    void init() {
//        sut = new VoorspellingService(voorspellingRepository);
//    }
//
//    @Test
//    void getCompetitieId() {
//        expected = "1";
//
//        actual = sut.getCompetitieId(jsoninput);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void getCoureurNaamTest() {
//        expected = "Max Verstappen";
//
//        actual = sut.getCoureurNaam(jsoninput);
//
//        assertEquals(expected, actual);
//    }
//}
