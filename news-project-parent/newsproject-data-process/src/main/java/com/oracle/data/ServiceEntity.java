package com.oracle.data;

import java.io.Serializable;
import java.util.List;

public class ServiceEntity<T> implements Serializable {

    private Integer code;
    private String msg;
    private T entity;
    private List<T> listData;

    public ServiceEntity() {
    }

    public ServiceEntity(Integer code, String msg, T entity, List<T> listData) {
        this.code = code;
        this.msg = msg;
        this.entity = entity;
        this.listData = listData;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public List<T> getListData() {
        return listData;
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }
}
