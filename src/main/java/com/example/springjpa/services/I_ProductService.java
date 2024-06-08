package com.example.springjpa.services;

import com.example.springjpa.models.Product;

import java.util.List;

public interface I_ProductService {
    public boolean addProduct (Product product);
    public List<Product> getListProduct();
    public String getString_ListProduct();
    public Product findProductById(Long productId);
    public boolean updateProduct(Product product);
}
