package com.oracle.news.service.api;

import com.oracle.data.ServiceEntity;
import com.oracle.pojo.NewsCatalog;

public interface NewsCatalogService {

    ServiceEntity<NewsCatalog> list();
}
