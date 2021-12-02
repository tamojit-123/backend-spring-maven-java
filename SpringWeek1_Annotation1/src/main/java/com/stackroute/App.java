package com.stackroute;

import com.stackroute.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext configApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        //User user=(User)configApplicationContext.getBean("User1");
        User user=configApplicationContext.getBean("User1",User.class);
        System.out.println(user);


    }
}
