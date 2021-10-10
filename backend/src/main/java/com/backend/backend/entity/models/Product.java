package com.backend.backend.entity.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "products")

public class Product implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

    int product_id;
    String name;
    String imageurl;
    String description;
    float price;
    String categoria;
    String subcategoria;


    public Product() {
    }

    public Product(int product_id, String name, String imageurl, String description, float price, String categoria, String subcategoria) {
        this.product_id = product_id;
        this.name = name;
        this.imageurl = imageurl;
        this.description = description;
        this.price = price;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return this.subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Product product_id(int product_id) {
        setProduct_id(product_id);
        return this;
    }

    public Product name(String name) {
        setName(name);
        return this;
    }

    public Product imageurl(String imageurl) {
        setImageurl(imageurl);
        return this;
    }

    public Product description(String description) {
        setDescription(description);
        return this;
    }

    public Product price(float price) {
        setPrice(price);
        return this;
    }

    public Product categoria(String categoria) {
        setCategoria(categoria);
        return this;
    }

    public Product subcategoria(String subcategoria) {
        setSubcategoria(subcategoria);
        return this;
    } 
}
