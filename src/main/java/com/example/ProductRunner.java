package com.example;

import com.example.DAO.CustomerDao;
import com.example.DAO.OrderDao;
import com.example.DAO.ProductDao;
import com.example.entity.Product;

import java.util.List;

public class ProductRunner {

    // DAOs are available instantly to every method in this class!
    private final CustomerDao customerDao;
    private final ProductDao productDao;
    private final OrderDao orderDao;

    public ProductRunner(CustomerDao customerDao, ProductDao productDao, OrderDao orderDao) {
        this.customerDao = customerDao;
        this.productDao = productDao;
        this.orderDao = orderDao;
    }

    // You can write all your SQL/Stream practice tasks right here:
    public void startPractice() {
        System.out.println("--- Starting Practice Tasks ---\n");
        System.out.println("==============================");
        System.out.println("All Products By price");
        topExpensiveTask(4);
        // Example Task Call
        System.out.println("==============================");
        System.out.println("Highest Price");
        highestPrice();

        System.out.println("==============================");
        System.out.println("Sec Highest Price");
        secHighestPrice();
    }

    private void findCustomersByCity(String city) {
        // We will write query and stream logic here soon!
        System.out.println("Finding customers in " + city + "...");
    }

    private void findAllByCategory(String cat) {
        List<Product> products = productDao.findAllByCategory(cat);
        products.forEach(System.out::println);
    }

    private void priceFilterTask(int price) {
        List<Product> products = productDao.findAll();
        List<Product> filtered = products
                .stream()
                .filter(product -> product.getPrice() > price)
                .toList();
        if (filtered.isEmpty()) {
            System.out.println("⚠️ No products found priced above ." + price);
        } else {
            filtered.forEach(System.out::println);
        }

    }
    private void topExpensiveTask(int limit){
        List<Product> products = productDao.findAll();
         products
                .stream()
                .sorted((o1, o2) -> Double.compare(o2.getPrice() , o1.getPrice()))
                .limit(limit).map(Product::getName)
                .toList()
                .forEach(System.out::println);
    }
    private void highestPrice(){
        List<Product> products = productDao.findAll();
        products.stream()
                .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
                .map(Product::getName)
                .limit(2).toList().forEach(System.out::println);
    }
    private void secHighestPrice(){
            List<Product> products = productDao.findAll();
            String name =  products.stream()
                    .sorted((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()))
                    .limit(2).toList().get(1).getName();

        System.out.println(name);

    }
}


