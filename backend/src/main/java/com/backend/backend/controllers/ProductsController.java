package com.backend.backend.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.backend.backend.entity.models.Product;
import com.backend.backend.entity.services.IProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:8100")
@RestController

public class ProductsController {
    @Autowired
    IProductService iProductService;

    @GetMapping("/products")
    List<Product> getAll() {
        return iProductService.getAll();
    }

    @GetMapping("/products/{product_id}")
    Product getOne(@PathVariable("product_id") int product_id) {
        Optional<Product> product = iProductService.getOne(product_id);

        if (product.isPresent()) {
            return product.get();
        }
        ;
        return null;
    }

    @PostMapping(value = "/products", consumes = "application/json")
    void add(@RequestBody String stringProduct) {
        ObjectMapper om = new ObjectMapper();
        try {
            Product product = om.readValue(stringProduct, Product.class);
            iProductService.add(product);
        } catch (JsonMappingException e) {

            e.printStackTrace();
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }
    }

    @PutMapping(value = "/products/{product_id}", consumes = "application/json")
    void update(@RequestBody String stringProduct, @PathVariable int product_id) {
        ObjectMapper om = new ObjectMapper();
        try {
            Product newProduct = om.readValue(stringProduct, Product.class);
            Optional<Product> product = iProductService.getOne(product_id);

            product.get().setProduct_id(newProduct.getProduct_id());
            product.get().setImageurl(newProduct.getImageurl());
            product.get().setName(newProduct.getName());
            product.get().setDescription(newProduct.getDescription());
            product.get().setPrice(newProduct.getPrice());

            iProductService.add(product.get());

        } catch (JsonMappingException e) {

            e.printStackTrace();
        } catch (JsonProcessingException e) {

            e.printStackTrace();
        }

    }

    @DeleteMapping("/products/{product_id}")
    void delete(@PathVariable("product_id") int product_id) {
        iProductService.delete(product_id);
    }

}
