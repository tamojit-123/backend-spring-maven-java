package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Customer customer = (Customer) applicationContext.getBean("customer");
        System.out.println(customer);
    }
}
