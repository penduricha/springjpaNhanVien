package com.example.springjpa.repositories;

import com.example.springjpa.models.Product;
import com.example.springjpa.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
}
