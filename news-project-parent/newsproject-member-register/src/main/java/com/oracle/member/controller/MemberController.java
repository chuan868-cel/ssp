package com.oracle.member.controller;

import com.oracle.data.ServiceEntity;
import com.oracle.member.pojo.ResponseEntity;
import com.oracle.member.service.api.MemberService;
import com.oracle.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/register")
    @ResponseBody
    public ResponseEntity register(Member member){
        System.err.println(member);

        ResponseEntity responseEntity =new ResponseEntity();
        ServiceEntity serviceEntity= this.memberService.register(member);
        if (serviceEntity.getCode()==0){
            responseEntity.setCode(200);
            return  responseEntity;
        }else {
            responseEntity.setCode(400);
            responseEntity.setMsg(serviceEntity.getMsg());
            return  responseEntity;
        }
    }

    @RequestMapping("/checkedMobileCode")
    @ResponseBody
    public ResponseEntity checkedMobileCode(String mobile,String code){
        ResponseEntity responseEntity =new ResponseEntity();
        if (code==null||"".equals(code)){
            responseEntity.setCode(500);
            responseEntity.setMsg("验证码不能为空");
            return responseEntity;
        }
        ServiceEntity serviceEntity =this.memberService.checkedMobileCode(mobile,code);
        if (serviceEntity.getCode()==0){
            responseEntity.setCode(200);
            return responseEntity;
        }else {
            responseEntity.setCode(400);
            responseEntity.setMsg("验证码不正确");
            return  responseEntity;
        }
    }

    @RequestMapping("getMobileCode")
    @ResponseBody
    public ResponseEntity getMobileCode(String mobile){
        ResponseEntity responseEntity = new ResponseEntity();
        ServiceEntity serviceEntity = this.memberService.getMobileCode(mobile);
        if(serviceEntity.getCode().equals(0)){
            responseEntity.setCode(200);
        }else{
            responseEntity.setCode(400);
        }
        return responseEntity;
    }

    @RequestMapping("/checkedMobile")
    @ResponseBody
    public ResponseEntity checkedMobile(String mobile){
        ResponseEntity responseEntity = new ResponseEntity();
        if(mobile==null||"".equals(mobile)){
            responseEntity.setCode(-1);
            responseEntity.setMsg("请输入手机号");
            return responseEntity;
        }
        ServiceEntity serviceEntity = this.memberService.checkedMobile(mobile);
        if(serviceEntity.getCode().equals(0)){
            responseEntity.setCode(200);
            responseEntity.setMsg(serviceEntity.getMsg());
            return responseEntity;
        }else{
            responseEntity.setCode(400);
            responseEntity.setMsg(serviceEntity.getMsg());
            return responseEntity;
        }
    }

    @RequestMapping("/checkedLoginName")
    @ResponseBody
    public ResponseEntity checkedLoginname(String loginname){
        ResponseEntity responseEntity =new ResponseEntity();
        if (loginname==null||"".equals(loginname)){
            responseEntity.setCode(400);
            responseEntity.setMsg("用户不能为空");
            return responseEntity;
        }
        ServiceEntity serviceEntity =this.memberService.checkedLoginname(loginname);
        if (serviceEntity.getCode()==0){
            responseEntity.setCode(200);
            return responseEntity;
        }else {
            responseEntity.setCode(400);
            responseEntity.setMsg("用户名已经存在请更换");
            return responseEntity;
        }
    }
}
