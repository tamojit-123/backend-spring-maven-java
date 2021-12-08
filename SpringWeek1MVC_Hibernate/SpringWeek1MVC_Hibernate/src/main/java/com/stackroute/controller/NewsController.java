package com.stackroute.controller;

import com.stackroute.model.News;
import com.stackroute.repository.INewsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

    //@Autowired
    private INewsDAO iNewsDAO;

    @Autowired
    NewsController(INewsDAO iNewsDAO)
    {
        this.iNewsDAO=iNewsDAO;
    }

    @GetMapping("/")
    public ModelAndView homePage()
    {
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("newsList",iNewsDAO.getAllNews());
        return modelAndView;
    }

    @PostMapping("/saveNews")
    public String saveNews(@ModelAttribute("news") News news, Model model)
    {
        boolean status=iNewsDAO.addNews(news);
        model.addAttribute("newsList",iNewsDAO.getAllNews());
        return "index";
    }
}
