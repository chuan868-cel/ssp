package com.oracle.search.service.impl;

import com.oracle.document.NewsIndex;
import com.oracle.mapper.NewsMapper;
import com.oracle.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName:IndexServiceImpl
 * @Author : chuan
 * @Date : 2019/7/29 20:31
 * @Version : 1.0
 **/
@Service
public class IndexServiceImpl implements IndexServiceApi{

    @Autowired
    private SolrTemplate solrTemplate;


    @Autowired
    private NewsMapper newsMapper;


    @Override
    public void addIndex(News news) {

        NewsIndex newsIndex = new NewsIndex();
        newsIndex.setId(news.getId());
        newsIndex.setTitle(news.getTitle());
        this.solrTemplate.saveBean(newsIndex);
        this.solrTemplate.commit();
    }

    @Override
    public void addIndex(Integer id) {
        News news = this.newsMapper.selectByPrimaryKey(id);
        NewsIndex newsIndex = new NewsIndex();
        newsIndex.setId(news.getId());
        newsIndex.setTitle(news.getTitle());
        this.solrTemplate.saveBean(newsIndex);
        this.solrTemplate.commit();
    }
}