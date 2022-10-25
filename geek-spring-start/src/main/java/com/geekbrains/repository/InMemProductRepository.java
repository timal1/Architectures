package com.geekbrains.repository;

import com.geekbrains.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InMemProductRepository implements ProductRepository {
    private List<Product> products;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void setProduct(Product product) {
        products.add(product);
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Пальто", 100),
                new Product(2L, "Шляпа", 20),
                new Product(3L, "Ботинки", 50),
                new Product(4L, "Рубашка", 25),
                new Product(5L, "Брюки", 30)

        ));
    }

    @Override
    public Product findById(Long id) {
        return products.stream().filter(p -> p.getId()
                .equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Нет продукта с id: " + id));
    }
}
