package com.example.spring6reactive.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    @Id
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
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

}
