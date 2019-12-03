package com.oracle.controller;

import com.oracle.log.service.api.LogService;
import com.oracle.common.page.PageView;
import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/log")
public class LogController {

    @Autowired
    private LogService logService;


    @RequestMapping("/listView")
    public String toList(){
        return "/admin/logs/list";
    }
    @RequestMapping("/add")
    @ResponseBody
    public String add(Log log, Model model){
        ServiceEntity se=new ServiceEntity();
        se=this.logService.save(log);
        if (se.getCode()==0){
            model.addAttribute("","添加成功");
        }
        return "";
    }


    @RequestMapping("/details")
    @ResponseBody
    public Map<String,Object> details(Integer id,Model model){
        Map<String, Object> dataMap=new HashMap<String, Object>();
        ServiceEntity<Log> se=this.logService.getLogsById(id);
        if (se.getCode()==0){
            dataMap.put("log", se.getEntity());
            dataMap.put("code", 200);
        }
        return dataMap;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list(Log log, Integer currentPage, Integer pageSize){
        if (currentPage==null || currentPage==0 || "".equals(currentPage)){
            currentPage=1;
        }
        if (pageSize==null || pageSize==0 || "".equals(pageSize)){
            pageSize=7;
        }
        ServiceEntity<PageView> serviceEntity=this.logService.queryLogs(log,currentPage,pageSize);
        Map<String, Object> dataMap=new HashMap<String, Object>();
        dataMap.put("dataList", serviceEntity.getEntity().getRecords());
        dataMap.put("rowCount", serviceEntity.getEntity().getRowCount());
        dataMap.put("pageSize", serviceEntity.getEntity().getPageSize());
        dataMap.put("pageCount", serviceEntity.getEntity().getPageCount());
        dataMap.put("executorName", log.getExecutorname());
        dataMap.put("currentPage", currentPage);
        return dataMap;
    }

}
