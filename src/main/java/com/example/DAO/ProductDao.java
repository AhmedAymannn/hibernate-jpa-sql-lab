package com.example.DAO;

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

    // Fetch all products where the category is 'Electronics'

    public List <Product> findAllByCategory (String category){
        String sql = "select * from products where category = :category";
        List <Product> products = entityManager.createNativeQuery(sql, Product.class)
                .setParameter("category",category)
                .getResultList();

        if (products.isEmpty()) {
            System.out.println("⚠️ No products found for category: " + category);
        }
        return products;

    }
}
