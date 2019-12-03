package com.oracle.admins.service.spi;

import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Permission;
import com.oracle.pojo.Roles;

import java.util.List;

public interface RoleService {

    ServiceEntity<Roles> list();

    ServiceEntity<Roles> selectRolesById(Integer id);

    ServiceEntity<Permission> selectRoleInPer(Integer id);

    ServiceEntity UpdateRoleInPer(Roles role, Integer[] perIds);

    ServiceEntity add(Roles role, Integer[] perIds);

    ServiceEntity deleteRoleById(Integer id);
}

