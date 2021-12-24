package com.stackroute.springRestfulWithMongo.service;


import com.stackroute.springRestfulWithMongo.exception.CustomerAlreadyExistsException;
import com.stackroute.springRestfulWithMongo.exception.CustomerNotFoundException;
import com.stackroute.springRestfulWithMongo.model.Address;
import com.stackroute.springRestfulWithMongo.model.Customer;
import com.stackroute.springRestfulWithMongo.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    private Customer customer1, customer2;
    private Address address1, address2;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        address1 = new Address("delhi", "delhi");
        customer1 = new Customer(1000, "anjali", address1, 986678577);

        address2 = new Address("mumbai", "maharastha");
        customer2 = new Customer(1001, "swati", address2, 896678577);

    }

    @AfterEach
    public void tearDown() {
        address1 = null;
        address2 = null;
        customer1 = null;
        customer2 = null;
    }

    @Test
    public void givenCustomerToSaveReturnSavedCustomer() throws CustomerAlreadyExistsException {
        when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(null));
        when(customerRepository.save(customer1)).thenReturn(customer1);
        assertEquals(customer1, customerService.saveCustomer(customer1));
        verify(customerRepository, times(1)).save(any());
        verify(customerRepository, times(1)).findById(anyInt());
//        when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(null));
//        when(customerRepository.save(customer1)).thenReturn(customer1);
//      //  when(customerRepository.save(any())).thenReturn(customer1);
//        assertEquals(customer1,customerService.saveCustomer(customer1));
//        verify(customerRepository,times(1)).save(any());
//        verify(customerRepository,times(1)).findById(any());

    }

    @Test
    public void givenCustomerToSaveReturnCustomerFailure() {
        when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(customer1));
        assertThrows(CustomerAlreadyExistsException.class, () -> customerService.saveCustomer(customer1));
        verify(customerRepository, times(0)).save(any());
        verify(customerRepository, times(1)).findById(any());

    }

    @Test
    public void givenCustomerToDeleteShouldDeleteSuccess() throws CustomerNotFoundException {
        when(customerRepository.findById(customer1.getCustomerId())).thenReturn(Optional.ofNullable(customer1));
        boolean flag = customerService.deleteCustomer(customer1.getCustomerId());
        assertEquals(true, flag);
        verify(customerRepository, times(1)).findById(anyInt());
        verify(customerRepository, times(1)).deleteById(anyInt());

    }


}