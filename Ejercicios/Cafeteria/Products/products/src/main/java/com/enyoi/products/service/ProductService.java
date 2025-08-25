package com.enyoi.products.service;

import com.enyoi.products.model.Product;
import com.enyoi.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product SaveNewProduct( String name){

        Product product = new Product();

        product.setStock(100);
        product.setName(name);

        return repository.save(product);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);

    }

    public Product updateStock(String id, Integer quantitySold){
        Product product = repository.findById(id).get();
        product.setStock((product.getStock() - quantitySold ));
        return repository.save(product);

    }


}
