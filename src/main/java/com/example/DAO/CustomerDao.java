package com.example.DAO;

import com.example.entity.Customer;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private final EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Customer> findAll(){
        return entityManager.createQuery("SELECT c FROM Customer c" , Customer.class).getResultList();
    }
    public Customer findByID(Long id) {
        return entityManager.find(Customer.class , id);
    }
}