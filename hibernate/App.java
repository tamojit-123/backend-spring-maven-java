package com.stackroute;

import com.stackroute.dao.UserDAOImpl;
import com.stackroute.model.User;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        UserDAOImpl dao=new UserDAOImpl();
        User user=new User(11,"jyoti","jyoti@gmail.com");
        System.out.println(dao.saveUser(user));

        List<User> listUser=dao.getAllUsers();
        listUser.forEach(i-> System.out.println(i));

    }
}
