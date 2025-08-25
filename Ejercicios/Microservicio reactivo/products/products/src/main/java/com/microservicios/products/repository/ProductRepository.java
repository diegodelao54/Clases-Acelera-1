package com.microservicios.products.repository;

import com.microservicios.products.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findAllById(Flux<String> id);
}
