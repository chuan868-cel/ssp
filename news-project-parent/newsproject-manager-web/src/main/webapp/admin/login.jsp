<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<shiro:authenticated>
<%
response.sendRedirect(request.getContextPath()+"/admin/common/main");
%>
</shiro:authenticated>
<%
String loginError = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
	if(loginError!=null){
		if(loginError.equals("org.apache.shiro.authc.pam.UnsupportedTokenException")){
			pageContext.setAttribute("loginError", "验证码错误");
		}else if(loginError.equals("org.apache.shiro.authc.UnknownAccountException")){
			pageContext.setAttribute("loginError", "用户名不存在或密码不正确");
		}else if(loginError.equals("org.apache.shiro.authc.IncorrectCredentialsException")){
			pageContext.setAttribute("loginError", "用户名不存在或密码不正确");
		}
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${root}/resources/css/pintuer.css">
    <link rel="stylesheet" href="${root}/resources/css/admin.css">
    <script src="${root}/resources/js/jquery.js"></script>
    <script src="${root}/resources/js/pintuer.js"></script>
<title>管理员登录</title>
</head>
<body>
	<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="login.jsp" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" value="admin" name="username" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" value="admin" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                           <img src="${root}/CaptServlet" alt="" width="100" height="32" class="passcode" style="height:43px;cursor:pointer;" onclick="this.src=this.src+'?'">
                                                   
                        </div>
                    </div>
                </div>
                <span style="color: red;font-size: 12px;">${loginError}</span>
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            </form>          
        </div>
    </div>
</div>
</body>
</html>