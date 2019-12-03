package com.oracle.search.service.impl;

import com.oracle.pojo.News;

/**
 * @ClassName:IndexServiceApi
 * @Author : chuan
 * @Date : 2019/7/29 20:30
 * @Version : 1.0
 **/
public interface IndexServiceApi {

    //不加index
    // 通过MQ中的消息     来确定 是否需要同步索引   可以是一个news对象  news.id

    void addIndex(News news);

    //TextMessage = {news:id:1 , title : xxxxx}->  转为  pojo   数据转换为NewsIndex
    //MQ新闻id  先从数据库中获取   这个新闻对象   然后在加  这个对象   转存至Solr


    void addIndex(Integer id);//读多写少   在集群上会做2 个方案
    //集群高可用  挂机  情况   极地发生   多台mysql   当一台mysql数据库出现  挂机后不会影响其他几台（统一）
    //一条数据   保存到一台上后  其他几台  会同步这些数据
    //高性能   读写分离

    //MQ  盘中需要空间   在这个2 台者前   有取舍
}