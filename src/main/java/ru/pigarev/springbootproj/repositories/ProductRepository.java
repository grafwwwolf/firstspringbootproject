package ru.pigarev.springbootproj.repositories;

import org.springframework.stereotype.Component;
import ru.pigarev.springbootproj.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void initRepository() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "black leather jacket", 3600.00),
                new Product(2L, "black leather bandana", 540.00),
                new Product(3L, "black jeans", 2200.00),
                new Product(4L, "black leather gloves", 1050.00),
                new Product(5L, "T-shirt with print \'AC/DC\' ", 700.00)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProduct(Long id) {

        return productList.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }

    public void saveProduct(Product product) {
        productList.add(product);
    }

    public void costUp(Product product) {

        product.setCost(product.getCost() + 1.0);
    }

    public void costDown(Product product) {

        product.setCost(product.getCost() - 1.0);
    }
}
