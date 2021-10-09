package com.backend.backend.entity.dao;

import com.backend.backend.entity.models.Product;

import org.springframework.data.repository.CrudRepository;

public interface IProductsDao extends CrudRepository<Product,Integer> {
    
}
