<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root}/resources/css/pintuer.css">
    <link rel="stylesheet" href="${root}/resources/css/admin.css">
    <script src="${root}/resources/js/jquery.js"></script>
</head>
<body>
	<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${root}/admin/manager/saveOrUpdate">
    <input type="hidden" name="id" value="${admin.id}"/>
      <div class="form-group">
        <div class="label">
          <label>登录名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${admin.loginname}" name="loginname" data-validate="required:请输入登录名" />
          <div class="tips"></div>
        </div>
      </div>

        <div class="form-group">
            <div class="label">
                <label>密码：</label>
            </div>
            <div class="field">
                <input type="text" class="input w50" value="${admin.pwd}" name="pwd" data-validate="required:请输入密码" />
                <div class="tips"></div>
            </div>
        </div>
     
       <div class="form-group">
          <div class="label">
            <label>角色：</label>
          </div>
          <div class="field" style="padding-top:8px;">
              <select name="roleId">
                  <c:forEach items="${roleList}" var="role">
                     <option value="${role.id}"<c:if test="${admin.roleId eq role.id}">selected</c:if>>${role.rolename}</option>
                  </c:forEach>
              </select>
          </div>
        </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>