package com.stackroute.springRestfulWithMongo.controller;

import com.stackroute.springRestfulWithMongo.exception.CustomerAlreadyExistsException;
import com.stackroute.springRestfulWithMongo.exception.CustomerNotFoundException;
import com.stackroute.springRestfulWithMongo.model.Customer;
import com.stackroute.springRestfulWithMongo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customerservice/")
public class CustomerController {

    private CustomerService customerService;

    private ResponseEntity responseEntity;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("customer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistsException {
        try {
            customerService.saveCustomer(customer);
            responseEntity = new ResponseEntity<>(customer, HttpStatus.CREATED);
        } catch (CustomerAlreadyExistsException e) {
            throw new CustomerAlreadyExistsException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }

    @GetMapping("customer")
    public ResponseEntity<?> getCustomerDetails() {
        try {
            List<Customer> customerList = customerService.getAllCustomerDetails();
            responseEntity = new ResponseEntity<>(customerList, HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        try {
            customerService.deleteCustomer(customerId);
            responseEntity = new ResponseEntity<>("Successfully deleted!!!!", HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    @GetMapping("customer/{city}")
    public ResponseEntity<?> getAllCustomerFromCity(@PathVariable String city) {
        try {
            responseEntity = new ResponseEntity(customerService.getAllCustomerFromCity(city), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
