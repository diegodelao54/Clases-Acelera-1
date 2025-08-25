package com.microservicios.products.controller;

import com.microservicios.products.entity.Product;
import com.microservicios.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping(value = "/saveProduct")
    public Mono<Product> saveProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

//    @GetMapping(value = "/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Product> getProductByIds(@RequestBody String id){
//        return service.getProductsById(Flux.fromIterable(id));
//    }

    @PostMapping(value = "/getProduct", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProductById(@RequestBody List<String> id){
        return service.getProductsById(Flux.fromIterable(id));
    }

}
