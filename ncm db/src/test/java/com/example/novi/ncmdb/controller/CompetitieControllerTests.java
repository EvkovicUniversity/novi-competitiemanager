package com.example.novi.ncmdb.controller;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class CompetitieControllerTests {

    /**
     * Happy path
     */
    @Test
    void getCompetitiesHappy() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/formula1/competities");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusLine().getStatusCode());
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
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/22");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusLine().getStatusCode());
    }

    @Test
    void getRaceId_RaceIdDoesNotExists() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/09837456");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusLine().getStatusCode());
    }

    @Test
    void getRaceId_RaceIdIsUndefined() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/undefined");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusLine().getStatusCode());
    }

    @Test
    void getRaceId_RaceIdIsNull() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/competities/raceuitslagen/raceId/" + null);

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusLine().getStatusCode());
    }

    @Test
    void getCompetitieById() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/competitiemanager/formula1/competities/22");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        Assertions.assertEquals(HttpStatus.OK.value(), response.getStatusLine().getStatusCode());
    }

}
