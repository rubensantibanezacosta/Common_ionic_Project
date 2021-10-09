package com.backend.backend.entity.services;

import java.util.List;
import java.util.Optional;
import com.backend.backend.entity.models.Product;

public interface IProductService {
    List<Product> getAll();
	Optional<Product> getOne(int product_id);
	void add(Product product);
	void delete(int product_id);
}
