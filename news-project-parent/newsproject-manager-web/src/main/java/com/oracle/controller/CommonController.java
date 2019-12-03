package com.oracle.controller;

import com.oracle.admins.service.spi.PerService;
import com.oracle.admins.service.spi.RoleService;
import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Permission;
import com.oracle.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/common")
public class CommonController {

    @Autowired
    private PerService permissionService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/main")
    public String main(){
        return "/admin/comm/main";
    }

    @RequestMapping("/welcome")
    public String weclome(){
        return "/admin/comm/welcome";
    }

    @RequestMapping("/wipeCache")
    @ResponseBody
    public String wipeCache(HttpServletRequest request){
        ServletContext sc=request.getServletContext();
        ServiceEntity<Permission> se=this.permissionService.list();
        int result=0;
        if (se.getCode()==0){
            sc.setAttribute("perList",se.getListData());
        }else{
            result++;
        }
        ServiceEntity<Roles> se2=this.roleService.list();
        if (se2.getCode()==0){
            sc.setAttribute("roleList",se2.getListData());
        }else{
            result++;
        }
        if (result<0){
            return "400";
        }
        return "200";
    }

}
