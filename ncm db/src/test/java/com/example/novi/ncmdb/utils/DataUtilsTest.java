package com.example.novi.ncmdb.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataUtilsTest {

    private DataUtils sut;

    private final String jsoninput = "{\n" +
            "    \"Max Verstappen\":\"1\"\n" +
            "}";

    private String expected;
    private String actual;

    @BeforeEach
    void init() {
        sut = new DataUtils();
        actual = "";
        expected = "";
    }

    @Test
    void extractDataTest(){
        //Arrange
        expected = "MaxVerstappen1";
        //Act
        actual = sut.extractData(jsoninput);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void extractNameTest(){
        expected = "Max Verstappen";

        actual = sut.extractName(jsoninput);

        assertEquals(expected, actual);
    }

    @Test
    void extractCompetitieIdTest(){
        expected = "1";

        actual = sut.extractCompetitieId(jsoninput);

        assertEquals(expected, actual);
    }

    @Test
    void addSpaceTest(){
        String input = "MaxVerstappen";
        expected = "Max Verstappen";

        actual = sut.addSpace(input, 3);

        assertEquals(expected, actual);
    }

    @Test
    void addNameSpaceTest(){
        String input = "AlexanderAlbon";
        expected = "Alexander Albon";

        actual = sut.addNameSpace(input);

        assertEquals(expected, actual);
    }
}
