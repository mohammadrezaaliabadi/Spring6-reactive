package com.example.spring6reactive.controllers;

import com.example.spring6reactive.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureWebTestClient
class CustomerControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void deleteById() {
    }

    @Test
    void patchExistingCustomer() {
    }

    @Test
    void updateExistingCustomer() {
        webTestClient.put()
                .uri(CustomerController.CUSTOMER_PATH_ID, 1)
                .body(Mono.just(getCustomerDto()), CustomerDTO.class)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    void createNewCustomer() {
        webTestClient.post().uri(CustomerController.CUSTOMER_PATH)
                .body(Mono.just(getCustomerDto()), CustomerDTO.class)
                .header("Content-Type", "application/json")
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().location("http://localhost:8080/api/v2/customer/4");
    }

    @Test
    void getCustomerById() {
        webTestClient.get().uri(CustomerController.CUSTOMER_PATH_ID, 1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-type", "application/json")
                .expectBody(CustomerDTO.class);
    }

    @Test
    void listCustomers() {
        webTestClient.get().uri(CustomerController.CUSTOMER_PATH)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-type", "application/json")
                .expectBody().jsonPath("$.size()").isEqualTo(3);
    }

    public static CustomerDTO getCustomerDto() {
        return CustomerDTO.builder()
                .customerName("Test Customer")
                .build();
    }
}