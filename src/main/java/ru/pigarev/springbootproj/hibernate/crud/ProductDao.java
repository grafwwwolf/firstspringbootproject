package ru.pigarev.springbootproj.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pigarev.springbootproj.hibernate.MySessionFactory;
import ru.pigarev.springbootproj.model.Buyer;
import ru.pigarev.springbootproj.model.Product;

import java.util.List;
import java.util.Objects;
@Repository
public class ProductDao {

    private SessionFactory factory;

    @Autowired
    public ProductDao() {

        factory = MySessionFactory.getFactory();
    }

    public Product findBy(Long id) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public void deleteById(Long id) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Product product) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product updateProduct = session.get(Product.class, product.getId());
            if (Objects.isNull(updateProduct)) {
                session.save(product);
            } else {
                updateProduct.setTitle(product.getTitle());
                updateProduct.setCost(product.getCost());
            }
            session.getTransaction().commit();
        }
    }

    public List<Product> findAll() {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product order by id").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void showProductBuyersById(Long id) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            System.out.println(product.getBuyers());
            session.getTransaction().commit();
        }
    }

    public void costUp(Product product) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product costUpProduct = session.get(Product.class, product.getId());
            costUpProduct.setCost(product.getCost() + 1.0);
            session.getTransaction().commit();
        }
    }

    public void costDown(Product product) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product costUpProduct = session.get(Product.class, product.getId());
            costUpProduct.setCost(product.getCost() - 1.0);
            session.getTransaction().commit();
        }
    }
}
