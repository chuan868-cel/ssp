package com.oracle.admins.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oracle.admins.service.spi.PerService;
import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Permission;
import com.oracle.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PerServiceImpl implements PerService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public ServiceEntity<Permission> list() {
        ServiceEntity<Permission> serviceEntity = new ServiceEntity<>();
        List<Permission> list = this.permissionMapper.selectByExample(null);
        serviceEntity.setCode(0);
        serviceEntity.setListData(list);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }
}
