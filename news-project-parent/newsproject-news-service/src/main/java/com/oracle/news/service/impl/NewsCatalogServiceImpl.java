package com.oracle.news.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oracle.data.ServiceEntity;
import com.oracle.mapper.NewsCatalogMapper;
import com.oracle.news.service.api.NewsCatalogService;
import com.oracle.pojo.NewsCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsCatalogServiceImpl implements NewsCatalogService {

    @Autowired
    private NewsCatalogMapper newsCatalogMapper;
    @Override
    public ServiceEntity<NewsCatalog> list() {
        ServiceEntity<NewsCatalog> serviceEntity = new ServiceEntity<>();
        List<NewsCatalog> list = this.newsCatalogMapper.selectByExample(null);
        serviceEntity.setCode(0);
        serviceEntity.setListData(list);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }
}
