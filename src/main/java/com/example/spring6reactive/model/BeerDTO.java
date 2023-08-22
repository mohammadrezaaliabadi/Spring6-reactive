package com.example.spring6reactive.model;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BeerDTO {

    private Integer id;
    @NotBlank
    @Size(min = 3, max = 255)
    private String beerName;
    @Size(min = 1, max = 255)
    private String beerStyle;
    @Size(max = 25)
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

}
