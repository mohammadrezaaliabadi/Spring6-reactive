package com.example.spring6reactive.services;

import com.example.spring6reactive.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BeerService {
    Flux<BeerDTO> listBeers();
    Mono<BeerDTO> getBeerById(Integer beerId);
}
