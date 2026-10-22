package com.example;
import com.example.DAO.CustomerDao;
import com.example.DAO.OrderDao;
import com.example.DAO.ProductDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpaUnit");
        EntityManager em = emf.createEntityManager();

        try {
            // Instantiate DAOs
            CustomerDao customerDao = new CustomerDao(em);
            ProductDao productDao = new ProductDao(em);
            OrderDao orderDao = new OrderDao(em);

            // Hand them over to your practice playground class
            ProductRunner productRunner = new ProductRunner(customerDao, productDao, orderDao);
            productRunner.startPractice();

            
            CustomerRunner customerRunner = new CustomerRunner();
            customerRunner.startPractice();
        } finally {
            em.close();
            emf.close();
        }
    }
}


