package com.stackroute;

import com.stackroute.model.User;
import org.springframework.context.annotation.Bean;

public class AppConfig {
    @Bean("User1")
    public User getUser(){
        return new User(1,"anjali","anjali@gmail.com");
    }

    @Bean("User2")
    public User getUser1(){
        return new User(2,"anjali2","anjali2@gmail.com");
    }
}
