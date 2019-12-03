<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${css}/pintuer.css">
    <link rel="stylesheet" href="${css}/admin.css">
    <script src="${js}/jquery.js"></script>
    <!-- 引入 BootStrap的css -->
    <link rel="stylesheet" type="text/css"
          href="${css}/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="${css}/bootstrap-theme.min.css">
    <!-- 引入BootStrap的JS -->
    <script type="text/javascript" src="${js}/jquery.js"></script>
    <script type="text/javascript" src="${js}/bootstrap.min.js"></script>
<body>
<div class="container">
    <div class="row">
            <table id="booksTable" class="table table-bordered btn-lg col-sm-7"
                   style="text-align: center">
                <tr>
                    <th colspan="2" style="text-align: center">日志详情</th>
                </tr>
                <tr>
                    <th style="text-align: right; padding-right: 20px">执行管理员</th>
                    <td>${log.executorname}</td>
                </tr>
                <tr>
                    <th style="text-align: right; padding-right: 20px;">请求IP地址</th>
                    <td readonly="readonly">${log.requestip}</td>
                </tr>
                <tr>
                    <th class="col-sm-3"
                        style="text-align: right; padding-right: 20px">方法名</th>
                    <td readonly="readonly">${log.executemethodname}</td>
                </tr>
                <tr>
                    <th style="text-align: right; padding-right: 20px;">参数</th>
                    <td readonly="readonly">${log.executeargs}</td>
                </tr>
                <tr>
                    <th style="text-align: right; padding-right: 20px;">执行时间(单位：毫秒)</th>
                    <td readonly="readonly">${log.executetime}</td>
                </tr>
                <tr>
                    <th style="text-align: right; padding-right: 20px;">操作时间</th>
                    <td readonly="readonly">${log.requestime}</td>
                </tr>
            </table>
    </div>
</div>
</body>
</html>