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
    public ProductService() {
        productRepository = new ProductRepository();
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

    public void costUp(Long id) {
        productRepository.costUp(getProduct(id));
    }

    public void costDown(Long id) {

        productRepository.costDown(getProduct(id));
    }

    public void removeProduct(Long id) {

        productRepository.removeProduct(id);
    }

    public void showProductBuyersById(Long id) {
        productRepository.showProductBuyersById(id);
    }
}
