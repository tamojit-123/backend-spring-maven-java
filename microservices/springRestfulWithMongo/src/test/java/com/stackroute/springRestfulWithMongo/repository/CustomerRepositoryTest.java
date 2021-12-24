package com.stackroute.springRestfulWithMongo.repository;


import com.stackroute.springRestfulWithMongo.model.Address;
import com.stackroute.springRestfulWithMongo.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)  //it integrates spring testContext framework with junit jupiter
@DataMongoTest   // this scans the class that contains @Document
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    private Address address;
    private Customer customer, customer2;

    @BeforeEach
    public void setUp() {
        address = new Address("delhi", "delhi");
        customer = new Customer(1000, "anjali", address, 986678577);

        address = new Address("mumbai", "maharastha");
        customer2 = new Customer(1001, "swati", address, 896678577);

    }

    @AfterEach
    public void tearDown() {
        address = null;
        customer = null;
        customer2 = null;
        customerRepository.deleteAll();
    }

    @Test
    public void givenCustomerToSaveReturnCustomer() {
        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        assertNotNull(customer1);
        assertEquals(customer.getCustomerId(), customer1.getCustomerId());
    }


    @Test
    public void givenTrackReturnAllCustomer() {
        customerRepository.insert(customer);
        customerRepository.insert(customer2);
        List<Customer> list = customerRepository.findAll();
        assertEquals(2, list.size());
        assertEquals("anjali", list.get(0).getCustomerName());
    }


    @Test
    public void givenCustomerToDeleteShouldReturnDeleteCustomer() {
        customerRepository.insert(customer);
        Customer customer1 = customerRepository.findById(customer.getCustomerId()).get();
        customerRepository.delete(customer1);
        assertEquals(Optional.empty(), customerRepository.findById(customer1.getCustomerId()));

    }

}