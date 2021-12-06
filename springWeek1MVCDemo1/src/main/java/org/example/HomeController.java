package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        System.out.println("hi");
        return "index";
    }


    @GetMapping("/feedback")
    public String feedbackPage() {
        return "feedback";
    }
}

/**
 * first we create the maven web app application
 * web.xml to define FrontController
 * dispatcher-servlet.xml
 * create one folder inside WEB-INF give it a name like view
 * move your jsp page into WEB-INF/view
 * right click on src create one directory main/java and create one java class their
 * java class behaves as controller so that annotate it with @Controller
 * define any method it's return type should be String, and it is public . annotate it with @GetMapping("/")
 * request->web.xml--->DispatcherServlet(FrontController)-->dispatcher-servlet.xml--->handler-mapping--controller-->View Resolver ---View ---Response
 */