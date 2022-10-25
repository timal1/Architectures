package com.geekbrains.controller;

import com.geekbrains.service.ProductService;
import com.geekbrains.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showAllProducts(Model uiModel) {
        List<Product> products = productService.getListProduct();
        uiModel.addAttribute("products", products);
        return "home";
    }

    @GetMapping(value = "/add_form")
    public String addProduct(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "add";
    }

    @PostMapping(value = "/product_add")
    public String create(Product product, Model uiModel) {
        productService.save(product);
        uiModel.addAttribute("product", product);
        return "result";
    }

}
