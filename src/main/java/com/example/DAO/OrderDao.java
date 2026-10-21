package com.example.DAO;

import com.example.entity.Customer;
import com.example.entity.Order;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderDao {
    private final EntityManager entityManager;

    public OrderDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Order> findAll(){
        return entityManager.createQuery("SELECT o FROM Order o " , Order.class).getResultList();
    }
    public Order findByID(Long id) {
        return entityManager.find(Order.class , id);
    }

}