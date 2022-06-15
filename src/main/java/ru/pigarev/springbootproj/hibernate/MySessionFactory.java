package ru.pigarev.springbootproj.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

public class MySessionFactory {

    @Bean
    public static SessionFactory getFactory() {
        return new Configuration()
                .configure("configs/crud/hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
