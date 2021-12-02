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
        Customer customer=(Customer)applicationContext.getBean("cust");
        System.out.println(customer);
        System.out.println();
        customer.getAddress().forEach(i-> System.out.println(i));

    }
}
