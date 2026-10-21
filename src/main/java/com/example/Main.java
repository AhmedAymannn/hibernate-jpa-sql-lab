package com.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class
Main {

    public static void main(String[] args) {
// 1. Create the EntityManagerFactory using the persistence unit name from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myJpaUnit");

        // 2. Open an EntityManager (equivalent to the JPA session)
        try (EntityManager em = emf.createEntityManager()) {
            System.out.println("\n--- Successfully Connected via JPA (Jakarta Pesistence)r! ---\n");

            // 3. Execute a native SQL query using standard JPA APIs
            String sql = "SELECT VERSION()";
            List<?> results = em.createNativeQuery(sql).getResultList();

            System.out.println("MySQL Version Result:");
            for (Object row : results) {
                System.out.println(" -> " + row);
            }

        } finally {
            emf.close();
        }
    }

    }


