package com.oracle.admins.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.oracle.admins.service.spi.AdminService;
import com.oracle.data.ServiceEntity;
import com.oracle.mapper.AdminsMapper;
import com.oracle.pojo.Admins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminsMapper adminsMapper;


    @Override
    public ServiceEntity<Admins> getAdminByLoginName(String loginname) {
        ServiceEntity<Admins> serviceEntity = new ServiceEntity<>();
        if(loginname==null||"".equals(loginname)){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("登录名称输入错误");
            return serviceEntity;
        }
        Admins admins = this.adminsMapper.selectAdminByName(loginname);
        serviceEntity.setCode(0);
        serviceEntity.setEntity(admins);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<String> getUrlById(Integer id) {
        ServiceEntity<String> serviceEntity = new ServiceEntity<>();
        List<String> list = this.adminsMapper.selectUrlById(id);
        serviceEntity.setCode(0);
        serviceEntity.setListData(list);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }

    @Override
    public ServiceEntity updateAdmin(Admins adminVo) {
        ServiceEntity<Admins> serviceEntity = new ServiceEntity<>();
        if(adminVo==null){
            serviceEntity.setCode(-3);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        adminsMapper.updateByPrimaryKey(adminVo);
        serviceEntity.setCode(0);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<Admins> getList() {
        ServiceEntity<Admins> serviceEntity = new ServiceEntity<>();
        List<Admins> list = this.adminsMapper.selectContainRole();
        serviceEntity.setCode(0);
        serviceEntity.setListData(list);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }

    @Override
    public ServiceEntity<Admins> selectAdminById(Integer id) {
        ServiceEntity<Admins> serviceEntity = new ServiceEntity<>();
        Admins admins = this.adminsMapper.selectContainRoleById(id).get(0);
        serviceEntity.setCode(0);
        serviceEntity.setEntity(admins);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }

    @Override
    public ServiceEntity updateById(Admins adminVo) {
        ServiceEntity<Admins> serviceEntity = new ServiceEntity<>();
        if(adminVo==null||"".equals(adminVo)){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        //  更新
        this.adminsMapper.updateByPrimaryKeySelective(adminVo);
        //  更新（删除、添加）  第三张表
        this.adminsMapper.deleteRoleByAdminId(adminVo.getId());
        this.adminsMapper.addRoleByAdminId(adminVo.getRoleId(),adminVo.getId());
        serviceEntity.setCode(0);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }

    @Override
    public ServiceEntity add(Admins adminVo) {
        ServiceEntity<Admins> serviceEntity = new ServiceEntity<>();
        if(adminVo==null||"".equals(adminVo)){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        this.adminsMapper.insertSelective(adminVo);
        this.adminsMapper.addRoleByAdminId(adminVo.getRoleId(),adminVo.getId());
        serviceEntity.setCode(0);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }

    @Override
    public ServiceEntity deleteAdminById(Integer id) {
        ServiceEntity<Admins> serviceEntity = new ServiceEntity<>();
        if(id==null||"".equals(id)){
            serviceEntity.setCode(-1);
            serviceEntity.setMsg("error");
            return serviceEntity;
        }
        this.adminsMapper.deleteByPrimaryKey(id);
        this.adminsMapper.deleteRoleByAdminId(id);
        serviceEntity.setCode(0);
        serviceEntity.setMsg("sucess");
        return serviceEntity;
    }


}
