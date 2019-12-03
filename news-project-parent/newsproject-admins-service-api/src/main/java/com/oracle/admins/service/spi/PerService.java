package com.oracle.admins.service.spi;

import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Permission;

import java.util.List;

public interface PerService {

    ServiceEntity<Permission> list();
}
