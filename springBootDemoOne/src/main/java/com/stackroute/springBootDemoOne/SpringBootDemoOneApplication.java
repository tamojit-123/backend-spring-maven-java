package com.stackroute.springBootDemoOne;

import com.stackroute.springBootDemoOne.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoOneApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootDemoOneApplication.class, args);
        MessageService messageService = context.getBean("messageService", MessageService.class);
        String message = messageService.sayHello();
        System.out.println(message);
    }

}
