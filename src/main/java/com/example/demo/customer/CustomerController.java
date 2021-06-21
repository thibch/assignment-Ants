package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Fait appel au customerService pour accéder à la liste des customers
     * @return la liste des customers
     */
    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    /**
     * Fait appel au customerService pour créer un nouveau clients
     */
    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    /**
     * Fait appel au customerService pour supprimer le customer avec l'id spécifique
     * @param customerId l'id du customer à supprimer
     */
    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){
        customerService.deleteCustomer(customerId);
    }

    /**
     * Fait appel au customerService pour modifier le customer avec l'id spécifique
     * @param customerId l'id du customer à modifier
     * @param email l'email à modifier
     */
    @PutMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long customerId,  String email){
        customerService.updateCustomer(customerId, email);
    }
}
