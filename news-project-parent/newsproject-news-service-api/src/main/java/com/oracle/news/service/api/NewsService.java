package com.oracle.news.service.api;

import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Admins;
import com.oracle.pojo.News;

public interface NewsService {

    ServiceEntity<News> list();

    ServiceEntity<News> selectNewsById(Integer id);

    ServiceEntity<News> add(News news);

    ServiceEntity<News> UpdateNewsByCatalog(News news);

    ServiceEntity<News> deleteRoleById(Integer id);
}
