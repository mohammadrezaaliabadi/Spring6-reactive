package com.example.spring6reactive.services;

import com.example.spring6reactive.model.BeerDTO;
import reactor.core.publisher.Flux;

public interface BeerService {
    Flux<BeerDTO> listBeers();
}
