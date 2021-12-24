package com.stackroute.springRestfulWithMongo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.springRestfulWithMongo.exception.CustomerAlreadyExistsException;
import com.stackroute.springRestfulWithMongo.model.Address;
import com.stackroute.springRestfulWithMongo.model.Customer;
import com.stackroute.springRestfulWithMongo.service.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    Customer customer1, customer2;

    Address address1, address2;

    @BeforeEach
    public void setUp() {
        address1 = new Address("delhi", "delhi");
        customer1 = new Customer(1000, "anjali", address1, 986678577);

        address2 = new Address("mumbai", "maharastha");
        customer2 = new Customer(1001, "swati", address2, 896678577);
        //we are registering our controller without the need of full webApplicationContext
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

    }

    @AfterEach
    public void tearDown() {
        address1 = null;
        address2 = null;
        customer1 = null;
        customer2 = null;
    }

    @Test
    public void givenCustomerToSaveReturnSaveCustomer() throws Exception {
        when(customerService.saveCustomer(any())).thenReturn(customer1);
        //when(customerService.saveCustomer(any())).thenReturn(customer1);
        mockMvc.perform(post("/api/v1/customerservice/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer1)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(customerService, times(1)).saveCustomer(any());
    }

    @Test
    public void givenCustomerToSaveCustomerFailure() throws Exception {
        when(customerService.saveCustomer(any())).thenThrow(CustomerAlreadyExistsException.class);
        mockMvc.perform(post("/api/v1/customerservice/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonToString(customer1)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(customerService, times(1)).saveCustomer(any());
    }


    @Test
    public void givenCustomerCodeDeleteCustomer() throws Exception {
        when(customerService.deleteCustomer(anyInt())).thenReturn(true);
        mockMvc.perform(delete("/api/v1/customerservice/customer/1000")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
        verify(customerService, times(1)).deleteCustomer(anyInt());
    }


    private static String jsonToString(final Object o) throws JsonProcessingException {
        String result;
        try {
            ObjectMapper mapper = new ObjectMapper();
            //we are converting json data into using ObjectMapper class
            String jsonContent = mapper.writeValueAsString(o);
            result = jsonContent;
            return result;

        } catch (JsonProcessingException e) {
            result = "JsonProcessingException";
        }
        return result;
    }


}