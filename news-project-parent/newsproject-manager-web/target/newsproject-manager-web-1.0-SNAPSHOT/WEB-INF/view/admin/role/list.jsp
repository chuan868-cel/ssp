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
    <script>
    <!--瞬时消息js-->
			$(function(){
				$("#div_message").hide();//初始 消失
				initMessage();
				function initMessage(){
					var message=$("#div_message").text();
					if(message.trim().length>0){
						$("#div_message").show();
						setTimeout(hide,1500);//1.5秒后消失
					}
					
				}
			})
			
			function hide(){
				$("#div_message").animate({opacity: "hide"}, "slideUp");
			}

    function del(th){
        var result=false;
        var roleName=$(th).parent().parent().prev().prev().text();
        if (roleName=="超级管理员"){
            alert("超级管理员不能删除")
            return;
        }
        if (confirm("确定要删除吗？")){
            result=true;
        }
        var trObj=$(th).parent().parent().parent();
        var id=$(th).attr("data-id");
        if (result){
            // 发送异步请求删除
            $.get(
                "${root}/admin/role/delete",
                {id:id},
                function (result){
                    if (result==200){
                        trObj.remove();
                    }
                },"text")
        }
    }
		</script>
		<style>
			#div_message {
			padding: 10px;
			border: 1px;
			-moz-border-radius: 15px;
			-webkit-border-radius: 15px;
			border-radius: 15px;
			background-color: #3fbc02;
			width: 200px;
			height: 50px;
			line-height: 50px;
			overflow: hidden;
			text-align: center;
			display: -webkit-flex;
			display: flex;
			-webkit-align-items: center;
			align-items: center;
			-webkit-justify-content: center;
			justify-content: center;
			color: white;
			position: absolute;
			font-size: 18px;
			top: 50%;
			left: 50%;
			margin:-150px 0 0 -100px;
			z-index: 9999;
		}
		</style> 
</head>
<body>
	
	<div class="panel admin-panel">
    <div class="panel-head">
        <strong class="icon-reorder"> 角色列表</strong>
        <a href="${root}/admin/role/edit" style="float:right">添加角色</a>
        </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th>名称</th>
        <th>描述</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
      <c:forEach items="${roleList}" var="r" varStatus="v">
        <tr>
          <td style="text-align:left; padding-left:20px;">
           ${v.count}</td>
          <td>${r.rolename }</td>
          <td>${r.description}</td>
          <td>
              <div class="button-group">
                  <a class="button border-main" href="${root}/admin/role/edit?id=${r.id}">
                      <span class="icon-edit"></span>编辑</a>
                  <a class="button border-red" href="javascript:void(0)" data-id="${r.id}" onclick="return del(this)">
                      <span class="icon-trash-o"></span> 删除</a>
              </div>
          </td>
        </tr>
   		</c:forEach>
    </table>
  </div>
  <div id="div_message">${editMessage}</div>
</body>
</html>