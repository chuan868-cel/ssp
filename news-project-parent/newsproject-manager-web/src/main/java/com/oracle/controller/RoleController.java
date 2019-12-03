package com.oracle.controller;


import com.oracle.admins.service.spi.PerService;
import com.oracle.admins.service.spi.RoleService;
import com.oracle.data.ServiceEntity;
import com.oracle.pojo.Admins;
import com.oracle.pojo.Permission;
import com.oracle.pojo.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired(required = false)
    private RoleService roleService;

    @Autowired(required = false)
    private PerService perService;

    @RequestMapping("/list")
    public String roleList(Model model){
        ServiceEntity<Roles> serviceEntity = this.roleService.list();
        model.addAttribute("roleList",serviceEntity.getListData());
        return "/admin/role/list";
    }

    @RequestMapping("/edit")
    public String roleEdit(Model model, Roles roles){
        ServiceEntity<Roles> SERolesId = this.roleService.selectRolesById(roles.getId());
        ServiceEntity<Permission> SEList = this.perService.list();
        ServiceEntity<Permission> SEList2 = this.roleService.selectRoleInPer(roles.getId());
        model.addAttribute("role",SERolesId.getEntity());
        model.addAttribute("perList",SEList.getListData());
        model.addAttribute("roleInPer",SEList2.getListData());
        return "/admin/role/edit";
    }

    @RequestMapping("/saveOrUpdate")
    public String roleSave(Roles roles, Integer[] perIds, RedirectAttributes redirectAttributes){
        ServiceEntity<Admins> serviceEntity;
        if(roles.getId()==null){
            serviceEntity = this.roleService.add(roles, perIds);
        }else{
            serviceEntity = this.roleService.UpdateRoleInPer(roles,perIds);
        }
        if (serviceEntity.getCode()==0){
            redirectAttributes.addAttribute("editMessage","操作成功");
        }else{
            redirectAttributes.addAttribute("editMessage","操作失败");
        }
        return "redirect:/admin/role/list";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String edit(Integer id){
        ServiceEntity<Admins> serviceEntity = this.roleService.deleteRoleById(id);
        if(serviceEntity.getCode()==0){
            return "200";
        }
        return "400";
    }

}
