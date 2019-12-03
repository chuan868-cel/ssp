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
    <form method="post" class="form-x" action="${root}/admin/role/saveOrUpdate">
    <input type="hidden" name="id" value="${role.id}"/>
      <div class="form-group">
        <div class="label">
          <label>角色名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="${role.rolename}" name="rolename" data-validate="required:请输入名称" />
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>角色描述：</label>
        </div>
        <div class="field">
          <textarea class="input" name="description" style=" height:90px;">${role.description}</textarea>
          <div class="tips"></div>
        </div>
      </div>
     
       <div class="form-group">
          <div class="label">
            <label>权限：</label>
          </div>
          <div class="field" style="padding-top:8px;">
          <c:forEach items="${perList}" var="per">
          	${per.pername}:<input name="perIds" type="checkbox" value="${per.id}" 
          	<c:forEach items="${roleInPer}" var="rolePer">
          		<c:if test="${rolePer.id eq per.id}">checked</c:if>
          	</c:forEach>/>
          </c:forEach> 
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