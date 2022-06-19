package ru.pigarev.springbootproj.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pigarev.springbootproj.hibernate.MySessionFactory;
import ru.pigarev.springbootproj.model.Buyer;
import ru.pigarev.springbootproj.model.Product;
@Repository
public class BuyerDao {

    private static SessionFactory factory;

    @Autowired
    public BuyerDao() {

        factory = MySessionFactory.getFactory();
    }

    public Buyer findBy(Long id) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

    public void showBuyersProductById(Long id) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            System.out.println(buyer);
            System.out.println(buyer.getProducts());
            session.getTransaction().commit();
        }
    }
}
