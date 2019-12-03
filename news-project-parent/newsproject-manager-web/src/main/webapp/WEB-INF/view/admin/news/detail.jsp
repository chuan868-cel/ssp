<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <!-- 引入 BootStrap的css -->
	  <link rel="stylesheet" type="text/css"
			href="${css}/bootstrap.min.css">
	  <link rel="stylesheet" type="text/css"
			href="${css}/bootstrap-theme.min.css">
	  <!-- 引入BootStrap的JS -->
	  <script type="text/javascript" src="${js}/jquery.js"></script>
	  <script type="text/javascript"
			  src="${js}/bootstrap.min.js"></script>

  </head>
  
  <body>
   	<div class="container">
    	<div class="row">
    <table id="booksTable" class="table table-bordered btn-lg col-sm-7" style="text-align: center">
		<tr>
			<th colspan="2" style="text-align: center">
				新闻详细信息
			</th>
		</tr>
		<tr>
			<th  class="col-sm-3" style="text-align: right; padding-right: 20px">新闻标题</th>
			<td>
				<div class="col-sm-12">
			      <input type="text" readonly="readonly" class="form-control" id="name" name="name" value="${news.title}">
			    </div>
			</td>
		</tr>
		<tr>
			<th style="text-align: right; padding-right: 20px">编者</th>
			<td>
				<input type="text" readonly="readonly" class="form-control" id="name" name="name" value="${news.author}">
			</td>
		</tr>
		<tr>
			<th style="text-align: right; padding-right: 20px">商品类型</th>
			<td>
			<div class="col-sm-3">
				<select name="cid"  class="form-control"  disabled="disabled">
					<option value="">新闻类型</option>
					<c:forEach items="${newsCataList}" var="t">
						<option value="${t.id}" <c:if test="${news.cid eq t.id}">selected</c:if>>${t.cname}</option>
					</c:forEach>
				</select>
			</div>
			</td>
		</tr>
		<tr>
			<th style="text-align: right; padding-right: 20px">创建时间</th>
			<td>
				<div class="col-sm-12">
					<fmt:formatDate value="${news.publishTime}" pattern="yyyy-MM-dd"/>
			    </div>
			</td>
		</tr>
		<tr>
			<th style="text-align: right; padding-right: 20px;">新闻信息</th>
			<td>
				${news.context}
			</td>
		</tr>
	</table>
	</div>
    </div>
  </body>
</html>
