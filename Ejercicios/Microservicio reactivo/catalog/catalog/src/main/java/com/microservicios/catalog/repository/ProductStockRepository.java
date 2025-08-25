package com.microservicios.catalog.repository;

import com.microservicios.catalog.entity.ProductStock;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ProductStockRepository extends R2dbcRepository<ProductStock, String> {

    Flux<ProductStock> findBystockGreaterThanEqual(Integer stock); //responde
}
