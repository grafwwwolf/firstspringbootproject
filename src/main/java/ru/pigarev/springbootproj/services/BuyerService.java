package ru.pigarev.springbootproj.services;

import org.springframework.stereotype.Service;
import ru.pigarev.springbootproj.repositories.BuyerRepository;

@Service
public class BuyerService {

private BuyerRepository buyerRepository;

    public BuyerService() {
        buyerRepository = new BuyerRepository();
    }

    public void showBuyersProductById(Long id) {
        buyerRepository.showBuyersProductById(id);
    }
}
