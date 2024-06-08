package com.example.springjpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="Store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Long storeId;
    @Column(name = "storeName", length = 100, columnDefinition = "nvarchar(20)",nullable = false)
    private String storeName;
    @Column(name = "address", length = 100, columnDefinition = "nvarchar(20)",nullable = false)
    private String address;
    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Product> listProduct=new ArrayList<>();

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store store)) return false;
        return Objects.equals(getStoreId(), store.getStoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getStoreId());
    }

    public Store() {
    }

    public Store(String storeName, String address) {
        this.storeName = storeName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
