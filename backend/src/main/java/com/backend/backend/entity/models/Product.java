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
    String imageurl;
    String name;
    String description;
    float price;


    public Product() {
    }

    public Product(int product_id, String imageurl, String name, String description, float price) {
        this.product_id = product_id;
        this.imageurl = imageurl;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Product product_id(int product_id) {
        setProduct_id(product_id);
        return this;
    }

    public Product imageurl(String imageurl) {
        setImageurl(imageurl);
        return this;
    }

    public Product name(String name) {
        setName(name);
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



}
