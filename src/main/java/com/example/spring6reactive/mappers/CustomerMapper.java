package com.example.spring6reactive.mappers;

import com.example.spring6reactive.domain.Customer;
import com.example.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}