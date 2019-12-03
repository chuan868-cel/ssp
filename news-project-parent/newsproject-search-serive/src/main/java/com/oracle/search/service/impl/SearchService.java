package com.oracle.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oracel.search.api.SearchApi;
import com.oracle.document.NewsIndex;
import com.oracle.mapper.NewsMapper;
import com.oracle.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;

import java.util.List;

/**
 * @ClassName:SearchService
 * @Author : chuan
 * @Date : 2019/7/29 17:23
 * @Version : 1.0
 **/
@Service
public class SearchService implements SearchApi {





    @Override
    public List<NewsIndex> searchNews(String keyWords) {
        return null;
    }

    @Override
    public void removeIndex(Integer id) {

    }
}