package ru.pigarev.springbootproj.repositories;

import org.springframework.stereotype.Repository;
import ru.pigarev.springbootproj.hibernate.PrepareDataApp;
import ru.pigarev.springbootproj.hibernate.crud.ProductDao;
import ru.pigarev.springbootproj.model.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductRepository {

    private ProductDao productDao;

    @PostConstruct
    public void initRepository() {
        productDao = new ProductDao();
        new PrepareDataApp().forcePrepareData();
    }

    public List<Product> getAllProducts() {

        return productDao.findAll();
    }

    public Product getProduct(Long id) {

        return productDao.findBy(id);
    }

    public void saveProduct(Product product) {

        productDao.saveOrUpdate(product);
    }

    public void costUp(Product product) {

        productDao.costUp(product);
    }

    public void costDown(Product product) {

        productDao.costDown(product);
    }

    public void removeProduct(Long id) {

        productDao.deleteById(id);
    }
}
