package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // GET
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    // POST
    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent()){ // Si le customer est présent on ne l'ajoute pas car il existe déjà
            throw new IllegalStateException("The email is taken");
        }
        customerRepository.save(customer); // Sauvegarde dans la base de données
    }

    // DELETE
    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){ // On ne peut pas supprimer un customer non présent
            throw new IllegalStateException("Customer with id " + customerId + " does not exists");
        }
        customerRepository.deleteById(customerId);
    }

    // PUT
    @Transactional
    public void updateCustomer(Long customerId, String email){
        boolean exists = customerRepository.existsById(customerId);
        if(!exists){ // On ne peut pas modifier un customer qui n'est pas présent
            throw new IllegalStateException("Customer with id " + customerId + " does not exists");
        }
        Customer customer = customerRepository.getById(customerId); // Récupère le customer avec l'id donnée en paramètre
        if(email != null && email.length() > 0 && !email.equals(customer.getEmail())){
            // Vérifie qu'un client n'as pas la même addresse email que celle en paramètre
            Optional<Customer> customerOptionnal = customerRepository.findCustomerByEmail(email);
            if(customerOptionnal.isPresent()){
                throw new IllegalStateException("email already taken");
            }
            customer.setEmail(email);
        }else{
            throw new IllegalStateException("invalid email");
        }
    }
}
