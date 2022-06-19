package ru.pigarev.springbootproj.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.pigarev.springbootproj.hibernate.crud.BuyerDao;
import ru.pigarev.springbootproj.model.Buyer;

//@Repository
public class BuyerRepository {

    private BuyerDao buyerDao;

    @Autowired
    public BuyerRepository() {
        buyerDao = new BuyerDao();
    }

    public Buyer getBuyerById(Long id) {
        return buyerDao.findBy(id);
    }

    public void showBuyersProductById(Long id) {

        buyerDao.showBuyersProductById(id);
    }
}
