package com.example;

import com.example.config.AppConfig;
import com.example.model.Account;
import com.example.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        BankService bankService = context.getBean(BankService.class);

        // Create accounts
        Account alice = new Account("Alice", 5000);
        Account bob = new Account("Bob", 3000);

        System.out.println("Before Transfer:");
        System.out.println(alice.getName() + " Balance: " + alice.getBalance());
        System.out.println(bob.getName() + " Balance: " + bob.getBalance());

        // Perform transfer
        bankService.transfer(alice, bob, 1000);

        System.out.println("After Transfer:");
        System.out.println(alice.getName() + " Balance: " + alice.getBalance());
        System.out.println(bob.getName() + " Balance: " + bob.getBalance());

        bankService.closeFactory();
    }
}
