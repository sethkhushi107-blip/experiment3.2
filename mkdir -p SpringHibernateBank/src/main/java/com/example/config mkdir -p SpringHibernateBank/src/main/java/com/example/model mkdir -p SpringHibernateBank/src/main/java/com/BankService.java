package com.example.service;

import com.example.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Service
public class BankService {

    private SessionFactory factory;

    public BankService() {
        factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Account.class)
                    .buildSessionFactory();
    }

    @Transactional
    public void transfer(Account from, Account to, double amount) {
        Session session = factory.openSession();
        session.beginTransaction();

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        session.update(from);
        session.update(to);

        session.getTransaction().commit();
        session.close();
    }

    public void closeFactory() {
        factory.close();
    }
}
