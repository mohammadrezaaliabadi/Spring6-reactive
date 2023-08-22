package com.example.spring6reactive.mappers;

import com.example.spring6reactive.domain.Beer;
import com.example.spring6reactive.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
