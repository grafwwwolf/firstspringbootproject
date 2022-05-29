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

    public void showProducts() {
        System.out.println("----------------------------------------------------");
        System.out.println("Список наших товаров:");
        productList.forEach(product -> System.out.println(product));
        System.out.println("Для добавления товара в корзину воспользуйтесь командой - add cart 'id', где 'id' - номер товара");
        System.out.println("или воспользуйтесь командой - addall cart");
        System.out.println("----------------------------------------------------");
    }
}
