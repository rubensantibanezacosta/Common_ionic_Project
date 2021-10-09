package com.backend.backend.entity.services;

import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.dao.IProductsDao;
import com.backend.backend.entity.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductsDao iProductsDao;

    @Override
    public List<Product> getAll() {
        return (List<Product>) iProductsDao.findAll();
    }

    @Override
    public void add(Product product) {
        iProductsDao.save(product);
    }

    @Override
    public void delete(int product_id) {
        iProductsDao.deleteById(product_id);
    }

    @Override
    public Optional<Product> getOne(int product_id) {
        return iProductsDao.findById(product_id);
    }
}
