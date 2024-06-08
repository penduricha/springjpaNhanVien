package com.example.springjpa.services.impl;

import com.example.springjpa.models.Product;
import com.example.springjpa.models.Store;

import com.example.springjpa.repositories.StoreRepository;
import com.example.springjpa.services.I_StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreService implements I_StoreService {
    private final StoreRepository storeRepository;
    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    @Override
    public boolean addStore(Store store) {
        try {
            storeRepository.save(store);
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Store> getListStore() {
        return storeRepository.findAll();
    }

    @Override
    public String getString_ListStore() {
        StringBuilder s= new StringBuilder();
        for(Store store: getListStore()){
            s.append(store.toString()).append("\n");
        }
        return s.toString();
    }
}
