package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        Customer customer= (Customer) applicationContext.getBean("customer");
        // customer inside getbean() we are fetching from beans.xml file
        System.out.println(customer);
        System.out.println(customer.getEmail());
    }
}
