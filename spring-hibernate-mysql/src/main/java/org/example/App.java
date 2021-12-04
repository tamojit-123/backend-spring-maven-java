package org.example;

import org.example.dao.UserDAOImpl;
import org.example.model.User;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        UserDAOImpl dao = new UserDAOImpl();
        User user = new User(11, "Tamojit", "tamo@gmail.com");
        System.out.println(dao.saveUser(user));

        List<User> listUser = dao.getAllUsers();
        listUser.forEach(System.out::println);
    }
}
