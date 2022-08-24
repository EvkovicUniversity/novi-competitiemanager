package com.example.novi.ncmdb.controller;

import com.example.novi.ncmdb.model.formula1.Competitie;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RaceuitslagControllerTests {

    @Test
    void eenLijstMet1extraRaceuitslag() throws IOException {
        //Ik wil de size van een racecontainer bekijken,
        // bevestigen dat deze 4 is .
        // Vervolgens raceuitslag maken, deze toevoegen aan racecontainer
        // En de bevestigen dat racecontainer 5 is.

        Competitie competitie = new Competitie("TestCompetitie");
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/formula1/competities/22");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        System.out.println(response.getEntity());
    }
}
