package com.example.DAO;

import com.example.entity.Customer;
import com.example.entity.Product;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductDao {
    private final EntityManager entityManager ;

    public ProductDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Product> findAll(){
        return entityManager.createQuery("SELECT p FROM Product p" , Product.class).getResultList();
    }
    public Product findByID (Long id){
        return entityManager.find(Product.class,id);
    }
}
