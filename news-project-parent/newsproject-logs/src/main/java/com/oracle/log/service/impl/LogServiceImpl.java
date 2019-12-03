package com.oracle.log.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oracle.log.service.api.LogService;
import com.oracle.common.page.PageView;
import com.oracle.data.ServiceEntity;
import com.oracle.mapper.LogMapper;
import com.oracle.pojo.Log;
import com.oracle.pojo.LogExample;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public ServiceEntity<Log> save(Log log) {
        ServiceEntity se=new ServiceEntity();
        try {
            // 保存的时候   让线程 睡6秒
            // 如果是  同步的话  只能等线程醒来之后  才能
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count=this.logMapper.insertSelective(log);
        if (count<=0){
            se.setCode(-1);
            return se;
        }
        se.setCode(0);
        return se;
    }

    @Override
    public ServiceEntity<Log> getLogsById(Integer id) {
        ServiceEntity<Log> se=new ServiceEntity<>();
        Log log=this.logMapper.selectByPrimaryKey(id);
        if (log==null){
            se.setCode(-1);
            return se;
        }
        se.setCode(0);
        se.setEntity(log);
        return se;
    }

    @Override
    public ServiceEntity<PageView> queryLogs(Log log, int currentPage, int pageSize) {
        ServiceEntity<PageView> serviceEntity = new ServiceEntity<>();
        // 创建  PageView
        PageView<Log> pageView=new PageView<>(pageSize,currentPage);
        // 创建  Page
        Page<Log> page= PageHelper.startPage(currentPage,pageSize);

        // 管理员名模糊查询
        LogExample example = new LogExample();
        LogExample.Criteria criteria = example.createCriteria();
        String executorName = (String)log.getExecutorname();
        // 添加查询规则
        if(executorName!=null && !"".equals(executorName)){
            criteria.andExecutornameLike("%"+executorName+"%");
        }
        // 按时间降序
        example.setOrderByClause("requestime desc");
        // 排除  访问日志的记录
        String str = "LogController";
        criteria.andExecutemethodnameNotLike("%"+str+"%");
        List<Log> logsList=this.logMapper.selectByExample(example);
        // 设置
        pageView.setQueryResult(page.getTotal(),logsList);
        serviceEntity.setEntity(pageView);
        return serviceEntity;
    }
}
