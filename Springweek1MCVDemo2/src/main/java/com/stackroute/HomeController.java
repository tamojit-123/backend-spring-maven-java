package com.stackroute;

import com.stackroute.model.News;
import com.stackroute.repository.NewsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HomeController {

    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    News news = context.getBean("news", News.class);
    NewsRepository newsRepository = context.getBean("newsRepository", NewsRepository.class);

    //@GetMapping("/")
    @RequestMapping("/")
    public String homePage(Model model) {
        System.out.println("Taking to the news HomePage");
        model.addAttribute("title", "News Information");
        return "index";
    }


    @RequestMapping(value = "/saveNews", method = RequestMethod.POST, headers = {"content-type=text/html"})
    //@PostMapping("/saveNews")
    //public String addNews(@RequestParam("newsId")int newsId,@ModelAttribute("news") News news, Model model)
    public String addNews(@ModelAttribute("news") News news, Model model) {
        System.out.println("News data is going to add");
        System.out.println("News data is going to add" + news);
        newsRepository.addNews(news);
        List<News> newsList = newsRepository.getNewsData();
        model.addAttribute("newsList", newsList); // first one is key second is the value that is defined in the line no 36
        return "index";
    }
}

/*
 * first we create the maven web app application
 * web.xml to define FrontController
 * dispatcher-servlet.xml
 * create one folder inside WEB-INF give it a name like view
 * move your jsp page into WEB-INF/view
 * right click on src create one directory main/java and create one java class their
 * java class behaves as controller so that annotate it with @Controller
 * define any method it's return type should be String, and it is public . annotate it with @GetMapping("/")
 *
 * request->web.xml--->DispatcherServlet(FrontController)-->dispatcher-servlet.xml--->handler-mapping--controller-->View Resolver ---View ---Response
 *
 * */






