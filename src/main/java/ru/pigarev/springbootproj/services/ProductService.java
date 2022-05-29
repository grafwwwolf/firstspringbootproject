package ru.pigarev.springbootproj.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pigarev.springbootproj.model.Product;
import ru.pigarev.springbootproj.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProduct(Long id) {
        return productRepository.getProduct(id);
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }
}
