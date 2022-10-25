package com.geekbrains.service;

import com.geekbrains.model.Product;
import com.geekbrains.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(@Qualifier("inMemProductRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getTitleById(Long id) {
        return productRepository.findById(id).getTitle();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }


    public List<Product> getListProduct() {
        return productRepository.getProducts();
    }

    public void save(Product product) {
        productRepository.setProduct(product);
    }
}
