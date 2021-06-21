package com.example.demo.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {
            Customer customer = new Customer(
                    "Watelot",
                    "Paul-Emile",
                    "paul.emile@gmail.com",
                    "0606060606"
            );
            Customer customer2 = new Customer(
                    "Colné",
                    "Clément",
                    "clem@pm.me",
                    "0707060606"
            );

            repository.saveAll(List.of(customer, customer2));
        };
    }
}
