package com.example.spring6reactive.controllers;

import com.example.spring6reactive.model.BeerDTO;
import com.example.spring6reactive.repositories.BeerRepositoryTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureWebTestClient
class BeerControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void deleteById() {
        webTestClient.delete()
                .uri(BeerController.BEER_PATH_ID,1)
                .exchange()
                .expectStatus().isNoContent();
    }


    @Test
    void updateExistingBeer() {
        webTestClient.put()
                .uri(BeerController.BEER_PATH_ID,1)
                .body(Mono.just(BeerRepositoryTest.getTestBeer()),BeerDTO.class)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    void createNewBeer() {
        webTestClient.post().uri(BeerController.BEER_PATH)
                .body(Mono.just(BeerRepositoryTest.getTestBeer()), BeerDTO.class)
                .header("Content-Type", "application/json")
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().location("http://localhost:8080/api/v2/beer/4");
    }

    @Test
    void getBeerById() {
        webTestClient.get().uri(BeerController.BEER_PATH_ID,1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-type", "application/json")
                .expectBody(BeerDTO.class);
    }

    @Test
    void listBeers() {

        webTestClient.get().uri(BeerController.BEER_PATH)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-type", "application/json")
                .expectBody().jsonPath("$.size()").isEqualTo(3);
    }
}