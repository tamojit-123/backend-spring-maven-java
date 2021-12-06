package com.stackroute.repository;

import com.stackroute.model.News;

import java.util.ArrayList;
import java.util.List;

public class NewsRepository {
    List<News> newsData;

    public NewsRepository(){

        newsData=new ArrayList<>();

    }

    public void addNews(News news){
        this.newsData.add(news);
    }

    public List<News> getNewsData(){
        return newsData;
    }
}
