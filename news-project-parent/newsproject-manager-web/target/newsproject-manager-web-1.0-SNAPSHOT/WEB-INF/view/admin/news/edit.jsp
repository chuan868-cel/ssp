<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>商品添加</title>

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
    <!-- kindeditor所使用CSS -->
    <link rel="stylesheet" type="text/css" href="${kindeditor}/themes/default/default.css">
    <link rel="stylesheet" type="text/css" href="${kindeditor}/plugins/code/prettify.css">
    <!-- kindeditor所使用JS -->
    <script type="text/javascript" src="${kindeditor}/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="${kindeditor}/lang/zh-CN.js"></script>
    <script type="text/javascript" src="${kindeditor}/plugins/code/prettify.js"></script>
    <script>
        KindEditor.ready(function(K) {
            var editor1 = K.create('#editor_id', {
                cssPath : '${kindeditor}/plugins/code/prettify.css',
                uploadJson : '${root}/admin/news/upload',
                fileManagerJson : '${root}/admin/news/upload'
            });
        });
    </script>
</head>

<body>
<div class="container">
    <div class="row">
        <form action="${root}/admin/news/saveOrUpdate" method="post"
              enctype="multipart/form-data">
            <table id="booksTable" class="table table-bordered btn-lg col-sm-7"
                   style="text-align: center">
                <tr>
                    <th colspan="2" style="text-align: center">添加新闻</th>
                </tr>
                <tr>
                    <th class="col-sm-3"
                        style="text-align: right; padding-right: 20px">新闻标题</th>
                    <td>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="name" name="title"
                                   value="${news.title}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th class="col-sm-3"
                        style="text-align: right; padding-right: 20px">作者</th>
                    <td>
                        <div class="col-sm-12">
                            <input type="text" class="form-control" id="name" name="author"
                                   value="${news.author}">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th style="text-align: right; padding-right: 20px">新闻类型</th>
                    <td>
                        <div class="col-sm-3">
                            <select name="cid"  class="form-control">
                                <option value="">新闻类型</option>
                                <c:forEach items="${newsCataList}" var="t">
                                    <option value="${t.id}" <c:if test="${news.cataid eq t.id}">selected</c:if>>${t.cname}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </td>
                </tr>
                <tr>
                    <th style="text-align: right; padding-right: 20px;">新闻详情</th>
                    <td><textarea class="form-control" rows="18" cols=""
                                  id="editor_id" name="context">${news.context}</textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit" class="btn btn-default">保存</button></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
