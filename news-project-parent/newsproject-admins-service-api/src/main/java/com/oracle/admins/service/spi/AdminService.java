package com.oracle.admins.service.spi;

import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Admins;

import java.util.List;

public interface AdminService {

    // 根据登录名返回一个 admin
    ServiceEntity<Admins> getAdminByLoginName(String loginname);

    // url
    ServiceEntity<String> getUrlById(Integer id);

    ServiceEntity updateAdmin(Admins adminVo);

    ServiceEntity<Admins> getList();

    ServiceEntity<Admins> selectAdminById(Integer id);

    ServiceEntity updateById(Admins adminVo);

    ServiceEntity add(Admins adminVo);

    ServiceEntity deleteAdminById(Integer id);
}
