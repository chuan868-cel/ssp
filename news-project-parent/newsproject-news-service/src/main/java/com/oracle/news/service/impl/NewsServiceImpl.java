package com.oracle.news.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oracle.data.ServiceEntity;
import com.oracle.mapper.NewsMapper;
import com.oracle.news.service.api.NewsService;
import com.oracle.pojo.News;
import com.oracle.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Override
    public ServiceEntity<News> list() {
        ServiceEntity<News> serviceEntity = new ServiceEntity<>();
        List<News> list = this.newsMapper.selectNewsAndCata();
        serviceEntity.setCode(0);
        serviceEntity.setListData(list);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<News> selectNewsById(Integer id) {
        ServiceEntity<News> serviceEntity = new ServiceEntity<>();
        News news = this.newsMapper.selectByPrimaryKey(id);
        serviceEntity.setCode(0);
        serviceEntity.setEntity(news);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<News> add(News news) {
        ServiceEntity<News> serviceEntity = new ServiceEntity<>();
        if(news.getTitle()==null&&!"".equals(news.getTitle())){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("标题不能为空");
            return serviceEntity;
        }
        if(news.getAuthor()==null&&!"".equals(news.getAuthor())){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("作者");
            return serviceEntity;
        }
        if(news.getCid()==null){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("新闻类型不能为空");
            return serviceEntity;
        }
        news.setPublishTime(new Date());
        this.newsMapper.insertSelective(news);
        serviceEntity.setCode(0);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<News> UpdateNewsByCatalog(News news) {
        ServiceEntity<News> serviceEntity = new ServiceEntity<>();
        if(news.getTitle()==null&&!"".equals(news.getTitle())){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("标题不能为空");
            return serviceEntity;
        }
        if(news.getAuthor()==null&&!"".equals(news.getAuthor())){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("作者");
            return serviceEntity;
        }
        if(news.getCid()==null){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("新闻类型不能为空");
            return serviceEntity;
        }
        news.setPublishTime(new Date());
        this.newsMapper.updateByPrimaryKeySelective(news);
        serviceEntity.setCode(0);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<News> deleteRoleById(Integer id) {
        ServiceEntity<News> serviceEntity = new ServiceEntity<>();
        if(id==null){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        this.newsMapper.deleteByPrimaryKey(id);
        serviceEntity.setCode(0);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }
}
