package com.stackroute.repository;

import com.stackroute.model.News;

import java.util.List;

public interface INewsDAO {
    public boolean addNews(News news);
    public List<News> getAllNews();
}
