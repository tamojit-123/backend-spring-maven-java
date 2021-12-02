package com.stackroute.config;

import com.stackroute.model.Address;
import com.stackroute.model.User;
import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean
    public Address getAddress()
    {
        return new Address(10,"marine Drive","Mumbai");
    }

    @Bean("user")
    public User getUser()
    {
        User user=new User();
        user.setUserId(10);
        user.setUserName("Anjali");
        user.setPassword("12345");

              return user;
    }


}
