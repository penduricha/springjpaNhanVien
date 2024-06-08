package com.example.springjpa.services.impl;

import com.example.springjpa.models.Product;
import com.example.springjpa.repositories.ProductRepository;
import com.example.springjpa.services.I_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements I_ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public List<Product> getListProduct() {
        return productRepository.findAll();
    }

    @Override
    public String getString_ListProduct() {
        String s="";
        for(Product product: getListProduct()){
            s+=product.toString()+"\n";
        }
        return s;
    }

    @Override
    public Product findProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }
    @Override
    public boolean updateProduct(Product product) {
        Product existingProduct = findProductById(product.getProductId());
        if (existingProduct!=null) {
            //Product existingProduct = existingProductOptional.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            productRepository.save(existingProduct);return true;
        }
        return false;
    }
}
