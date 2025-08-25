package com.microservicios.products.service;

import com.microservicios.products.entity.Product;
import com.microservicios.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repositoryProduct;

    public Mono<Product> saveProduct(Product producto){
        return repositoryProduct.save(producto);
    }

    public Flux<Product> getProductsById(Flux<String> idFlux){
        return repositoryProduct.findAllById(idFlux);
    }

}
