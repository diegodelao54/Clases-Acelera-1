package com.enyoi.products.controller;

import com.enyoi.products.dto.SaveNewProductDto;
import com.enyoi.products.dto.UpdateProductDto;
import com.enyoi.products.model.Product;
import com.enyoi.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> saveNewProduct(@RequestBody SaveNewProductDto dto){

        Product product = service.SaveNewProduct(dto.getName());
        return ResponseEntity.ok(product);
    }


    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name){
        Product product = service.getProductByName(name);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateStock(@PathVariable("id") String id, @RequestBody UpdateProductDto dto){

        Product product = service.updateStock(id, dto.getQuantitySold());
        return ResponseEntity.ok(product);
    }
}
