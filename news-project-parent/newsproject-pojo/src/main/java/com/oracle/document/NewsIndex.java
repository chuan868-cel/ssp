package com.oracle.document;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @ClassName:NewsIndex
 * @Author : chuan
 * @Date : 2019/7/29 17:00
 * @Version : 1.0
 **/
public class NewsIndex implements Serializable {

    @Field
    private Integer id;

    @Field
    private String title;


    public NewsIndex(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public NewsIndex() {
        super();
    }
}