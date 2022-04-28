package com.example.novi.ncmdb.controller;

import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.Competitie;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieController;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieRepository;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.competitie.CompetitieService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.coureur.CoureurService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.races.RacesService;
import com.example.novi.ncmdb.domain.competitiemanager.formula1.raceuitslag.RaceuitslagService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

public class CompetitieControllerTests {

    /**
     * Happy path
     */
    @Test
    void getCompetitiesHappy() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/formula1/competities");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK.value());
    }

    @Test
    void getCompetities_responseIsJson() throws IOException {
        String jsonMime = "application/json";
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/formula1/competities");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String type = ContentType.getOrDefault(response.getEntity()).getMimeType();
        Assertions.assertEquals(jsonMime, type);
    }

    /**
     * Happy path
     */
    @Test
    void getRaceIdHappy() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/215");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK.value());
    }

    @Test
    void getRaceId_RaceIdDoesNotExists() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/09837456");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.NOT_FOUND.value());
    }

    @Test
    void getRaceId_RaceIdIsUndefined() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/undefined");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.NOT_FOUND.value());
    }

    @Test
    void getRaceId_RaceIdIsNull() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/" + null);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.NOT_FOUND.value());
    }

    @Test
    void getCompetitieById() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/formula1/competities/215");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK.value());
    }

}
