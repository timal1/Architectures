package com.geekbrains.repository;

import com.geekbrains.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository {
    Product findById(Long id);

    List<Product> getProducts();

    void setProduct(Product product);
}
