package com.oracle.log.service.api;

import com.oracle.common.page.PageView;
import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Log;

public interface LogService {

    ServiceEntity<Log> save(Log log);

    ServiceEntity<Log> getLogsById(Integer id);

    ServiceEntity<PageView> queryLogs(Log log, int currentPage, int pageSize);
}
