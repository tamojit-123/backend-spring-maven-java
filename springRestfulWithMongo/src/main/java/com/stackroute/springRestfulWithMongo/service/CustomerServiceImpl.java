package com.stackroute.springRestfulWithMongo.service;

import com.stackroute.springRestfulWithMongo.exception.CustomerAlreadyExistsException;
import com.stackroute.springRestfulWithMongo.exception.CustomerNotFoundException;
import com.stackroute.springRestfulWithMongo.model.Customer;
import com.stackroute.springRestfulWithMongo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistsException {
        if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
            throw new CustomerAlreadyExistsException();
        }
        return customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        boolean flag = false;
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new CustomerNotFoundException();
        } else {
            customerRepository.deleteById(customerId);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Customer> getAllCustomerDetails() throws Exception {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomerFromCity(String city) throws CustomerNotFoundException {
        if (customerRepository.findAllCustomerFromCity(city).isEmpty()) {
            throw new CustomerNotFoundException();
        }
        return customerRepository.findAllCustomerFromCity(city);
    }
}
