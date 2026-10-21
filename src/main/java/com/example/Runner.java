package com.example;

import com.example.DAO.CustomerDao;
import com.example.DAO.OrderDao;
import com.example.DAO.ProductDao;

public class Runner {

    // DAOs are available instantly to every method in this class!
    private final CustomerDao customerDao;
    private final ProductDao productDao;
    private final OrderDao orderDao;

    public Runner(CustomerDao customerDao, ProductDao productDao, OrderDao orderDao) {
        this.customerDao = customerDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
    }

    // You can write all your SQL/Stream practice tasks right here:
    public void startPractice() {
        System.out.println("--- Starting Practice Tasks ---\n");

        // Example Task Call
        findCustomersByCity("New York");
    }

    private void findCustomersByCity(String city) {
        // We will write query and stream logic here soon!
        System.out.println("Finding customers in " + city + "...");
    }

    

}
