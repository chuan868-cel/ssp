package com.oracel.search.api;

import com.oracle.document.NewsIndex;
import com.oracle.pojo.News;

import java.util.List;

/**
 * @ClassName:SearchApi
 * @Author : chuan
 * @Date : 2019/7/29 17:10
 * @Version : 1.0
 **/
public interface SearchApi {


    List<NewsIndex> searchNews(String keyWords);

    void removeIndex(Integer id);

}