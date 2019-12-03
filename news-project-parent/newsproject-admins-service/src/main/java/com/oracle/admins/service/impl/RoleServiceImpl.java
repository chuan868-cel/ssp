package com.oracle.admins.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oracle.admins.service.spi.RoleService;
import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Permission;
import com.oracle.pojo.Roles;
import com.oracle.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesMapper rolesMapper;


    @Override
    public ServiceEntity<Roles> list() {
        ServiceEntity<Roles> serviceEntity = new ServiceEntity<>();
        List<Roles> list = this.rolesMapper.selectByExample(null);
        serviceEntity.setCode(0);
        serviceEntity.setListData(list);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<Roles> selectRolesById(Integer id) {
        ServiceEntity<Roles> serviceEntity = new ServiceEntity<>();
        Roles roles = this.rolesMapper.selectByPrimaryKey(id);
        serviceEntity.setCode(0);
        serviceEntity.setEntity(roles);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<Permission> selectRoleInPer(Integer id) {
        ServiceEntity<Permission> serviceEntity = new ServiceEntity<>();
        List<Permission> list = this.rolesMapper.selectRoleInPer(id);
        serviceEntity.setCode(0);
        serviceEntity.setListData(list);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity UpdateRoleInPer(Roles role, Integer[] perIds) {
        ServiceEntity<Roles> serviceEntity = new ServiceEntity<>();
        if(role==null||"".equals(role)||perIds.length==0){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        this.rolesMapper.updateByPrimaryKeySelective(role);
        this.rolesMapper.deleteRoleInPer(role.getId());
        for (int i = 0; i < perIds.length; i++) {
            this.rolesMapper.addPermissionByRoleId(role.getId(),perIds[i]);
        }
        serviceEntity.setCode(0);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity add(Roles role, Integer[] perIds) {
        ServiceEntity<Roles> serviceEntity = new ServiceEntity<>();
        if(role==null||"".equals(role)||perIds.length==0){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        this.rolesMapper.insertSelective(role);
        for (int i=0; i<perIds.length; i++){
            this.rolesMapper.addPermissionByRoleId(role.getId(),perIds[i]);
        }
        serviceEntity.setCode(0);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }

    @Override
    public ServiceEntity deleteRoleById(Integer id) {
        ServiceEntity<Roles> serviceEntity = new ServiceEntity<>();
        if(id==null){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        this.rolesMapper.deleteByPrimaryKey(id);
        //  删除  角色对应的权限
        this.rolesMapper.deleteRoleInPer(id);
        serviceEntity.setCode(0);
        serviceEntity.setMsg("success");
        return serviceEntity;
    }
}
