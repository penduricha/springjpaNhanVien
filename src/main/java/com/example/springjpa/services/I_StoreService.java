package com.example.springjpa.services;

import com.example.springjpa.models.*;

import java.util.List;

public interface I_StoreService {
    public boolean addStore (Store store);
    public List<Store> getListStore();
    public String getString_ListStore();
}
