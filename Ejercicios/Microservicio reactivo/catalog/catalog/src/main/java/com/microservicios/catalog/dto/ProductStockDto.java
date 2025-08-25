package com.microservicios.catalog.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductStockDto {

    private String Id;
    private String name;
    private String description;
    private Integer stock;
}
