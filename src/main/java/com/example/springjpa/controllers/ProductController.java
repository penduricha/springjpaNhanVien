package com.example.springjpa.controllers;

import com.example.springjpa.models.Product;
import com.example.springjpa.services.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
//GET POST PUT DEL
//CRUD
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getListProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<List<Product>> addUser(@RequestBody Product product) {
        productService.addProduct(product);
        List<Product> productList = productService.getListProduct();
        return ResponseEntity.ok(productList);
    }
    /*
    @PutMapping("/products/{productId}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        // Kiểm tra xem sản phẩm có tồn tại trong hệ thống hay không dựa trên productId
        boolean isProductExist = productService.isProductExist(productId);
        if (isProductExist) {
            // Cập nhật thông tin sản phẩm
            productService.updateProduct(productId, updatedProduct);

            // Lấy danh sách sản phẩm sau khi cập nhật
            List<Product> productList = productService.getListProduct();

            return ResponseEntity.ok(productList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        product.setProductId(productId);
        boolean isUpdated = productService.updateProduct(product);
        if (isUpdated) {
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
