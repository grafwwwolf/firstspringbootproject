package ru.pigarev.springbootproj;

import ru.pigarev.springbootproj.hibernate.PrepareDataApp;
import ru.pigarev.springbootproj.services.BuyerService;
import ru.pigarev.springbootproj.services.ProductService;

public class App {

    public static void main(String[] args) {

        new PrepareDataApp().forcePrepareData();

        new BuyerService().showBuyersProductById(1L);
        new ProductService().showProductBuyersById(1L);
    }
}
