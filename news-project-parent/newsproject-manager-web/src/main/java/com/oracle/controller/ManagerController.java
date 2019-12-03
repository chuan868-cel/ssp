package com.oracle.controller;

import com.oracle.admins.service.spi.AdminService;
import com.oracle.admins.service.spi.RoleService;
import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Admins;
import com.oracle.pojo.Roles;
import com.oracle.shiro.Principal;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin/manager")
public class ManagerController {

    @Autowired(required = false)
    private AdminService adminService;

    @Autowired(required = false)
    private RoleService roleService;

    @RequestMapping("/list")
    public String list(Model model){
        ServiceEntity<Admins> serviceEntity=this.adminService.getList();
        model.addAttribute("adminList",serviceEntity.getListData());
        return "/admin/manager/list";
    }

    @RequestMapping("/addView")
    public String addView(Model model){
        ServiceEntity<Roles> serviceEntity=this.roleService.list();
        model.addAttribute("roleList",serviceEntity.getListData());
        return "/admin/manager/edit";
    }

    @RequestMapping("/edit")
    public String edit(Integer id,Model model){
        ServiceEntity<Admins> serviceEntity=this.adminService.selectAdminById(id);
        ServiceEntity<Roles> SERoleList=this.roleService.list();
        model.addAttribute("admin",serviceEntity.getEntity());
        model.addAttribute("roleList",SERoleList.getListData());
        return "/admin/manager/edit";
    }

    @RequestMapping("/saveOrUpdate")
    public String save(Admins admin, RedirectAttributes redirectAttributes){
        ServiceEntity<Admins> serviceEntity;
        if (!(admin.getId()==null)){
            //  调用修改方法
            serviceEntity=this.adminService.updateById(admin);
        }else {
            // 添加
            serviceEntity = this.adminService.getAdminByLoginName(admin.getLoginname());
            if(serviceEntity.getEntity()!=null){
                redirectAttributes.addAttribute("editMessage","添加重复");
            }else{
                serviceEntity=this.adminService.add(admin);
            }
        }
        if (serviceEntity.getCode()==0){
            redirectAttributes.addAttribute("editMessage","操作成功");
        }else{
            redirectAttributes.addAttribute("editMessage","操作失败");
        }
        return "redirect:/admin/manager/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String edit(Integer id){
        Principal principal = (Principal) SecurityUtils.getSubject().getPrincipal();
        String loginname = this.adminService.selectAdminById(id).getEntity().getLoginname();
        if(principal.getLoginName().equals(loginname)){
            return "500";
        }
        ServiceEntity<Admins> serviceEntity = this.adminService.deleteAdminById(id);
        if(serviceEntity.getCode()==0){
            return "200";
        }
        return "400";
    }
}
