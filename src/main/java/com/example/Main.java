package com.example;
import com.example.DAO.CustomerDao;
import com.example.DAO.OrderDao;
import com.example.DAO.ProductDao;
import com.example.entity.Customer;
import com.example.entity.Order;
import com.example.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        // 1. Initialize EntityManagerFactory and EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpaUnit");
        EntityManager em = emf.createEntityManager();

        try {
            // 2. Instantiate all DAOs, passing the shared EntityManager
            CustomerDao customerDao = new CustomerDao(em);
            ProductDao productDao = new ProductDao(em);
            OrderDao orderDao = new OrderDao(em);
            System.out.println("\n--- Successfully Initialized All DAOs! ---\n");
            System.out.println("=======================================");
            System.out.println("All Customers");
            System.out.println("=======================================");
            List <Customer> customers = customerDao.findAll();
            customers.forEach(System.out::println);
            System.out.println("=======================================");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 4. Clean up resources
            em.close();
            emf.close();
        }
    }
}


