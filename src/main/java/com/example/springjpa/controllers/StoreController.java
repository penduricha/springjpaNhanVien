package com.example.springjpa.controllers;

import com.example.springjpa.models.Product;
import com.example.springjpa.models.Store;
import com.example.springjpa.services.impl.ProductService;
import com.example.springjpa.services.impl.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAllStore() {
        List<Store> stores = storeService.getListStore();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
}
