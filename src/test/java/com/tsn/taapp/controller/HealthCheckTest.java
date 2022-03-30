package com.tsn.taapp.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = com.tsn.taapp.Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HealthCheckTest {

    @LocalServerPort
    private int port;
    private String baseUrl;

    protected void setBaseUrl() {
        this.baseUrl = "http://localhost:" + port + "/gw/";
    }

    @BeforeAll
    void init() {
        setBaseUrl();
    }

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getHealthCheck() throws Exception {
        ResponseEntity<String> response = template.getForEntity(baseUrl + "health-check", String.class);
        assertThat(response.getBody()).isEqualTo("I am working");
    }
}