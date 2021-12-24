package com.stackroute.springRestfulWithMongo.service;

import com.stackroute.springRestfulWithMongo.exception.CustomerAlreadyExistsException;
import com.stackroute.springRestfulWithMongo.exception.CustomerNotFoundException;
import com.stackroute.springRestfulWithMongo.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException;

    boolean deleteCustomer(int customerId) throws CustomerNotFoundException;

    List<Customer> getAllCustomerDetails() throws Exception;

    List<Customer> getAllCustomerFromCity(String city) throws CustomerNotFoundException;


}
