package com.example.demo.customer;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String name;
    private String firstName;
    private String email;
    private String phoneNumber;

    public Customer(){

    }

    public Customer(Long id, String name, String firstName, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String firstName, String email, String phoneNumber) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String address) {
        this.email = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", FirstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
