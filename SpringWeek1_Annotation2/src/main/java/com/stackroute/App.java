package com.stackroute;

import com.stackroute.config.AppConfig;
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
        User user=configApplicationContext.getBean("user",User.class);
        System.out.println(user.getAddress().getCity());
        System.out.println(user);


    }
}
