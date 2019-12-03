<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>日志列表</title>
	<link rel="stylesheet" href="${root}/resources/css/pintuer.css">
	<link rel="stylesheet" href="${root}/resources/css/admin.css">
	<link rel="stylesheet" href="${root}/resources/css/kkpage-o.css">
	<link rel="stylesheet" href="${root}/resources/css/bootstrap.min.css">
	<script src="${root}/resources/js/pintuer.js"></script>
	<script src="${root}/resources/js/jquery.js"></script>
	<style type="text/css">
		td{
			font-size: 13px;
		}
		th{
			text-align: center;
		}

		.popWindow {
			text-align: center;
			z-index: 2;
			width: 720px;
			height: 460px;
			left: 50%;
			top: 50%;
			border: 4px solid #D3D3D3;
			border-radius: 3px;
			margin-left: -350px;
			margin-top: -250px;
			position: absolute;
			background: #ffffff;
			position: fixed;
		}
		.body-box{
			width: 100%;
			height: 160px;
		}
		#close-btn{
			width: 270px;
			height: 40px;
			margin: 30px auto;
			text-align: center;
		}
		#close-btn a{
			line-height: 22px;
			text-decoration: none;
			display: inline-block;
			cursor:pointer;
			width: 80px;
			height: 30px;
			background: #E33C3F;
			border: 0px solid;
			font-size: 14px;
			color: white;
			padding: 5px 20px;
			margin-left: 10px;
			margin-right: 10px;
		}
		.maskLayer {
			position: fixed;
			background: #D9D9D9;
			width: 100%;
			height: 100%;
			left: 0;
			top: 0;
			filter: alpha(opacity=50);
			opacity: 0.5;
			z-index: 1;
		}

	</style>
</head>
<body id="totalBody">
<div class="panel admin-panel">
	<div class="panel-head">
		<strong class="icon-reorder"> 日志列表</strong>
	</div>
	<div class="panel-head">
		<input style="color: red; border-shadow: 0"  value="已经过滤系统请求日志信息" readonly>
		<input name="executorname" placeholder="全部管理员" value="${logs.executorname}" id="executorname"><a href="javascript:loadData()" class="searchBtn">搜索</a>
	</div>
	<table class="table table-hover table-bordered text-center">
		<tr>
			<th width="100" style="text-align:left; padding-left:20px;">序号</th>
			<th>操作管理员</th>
			<th>请求Ip</th>
			<th>请求描述</th>
			<th>请求时间</th>
			<th>操作时间</th>
			<th width="310">操作</th>
		</tr>
		<tbody id="table-infoBody">

		</tbody>
	</table>
	<div>
		<div id="div-pageInfo" class="pull-right clearfix m-t-20 pages">
			<div id="kkpager" style="wdith: 400px;margin-left: 0px;" ></div>
		</div>
	</div>
</div>
<!-- 询问弹窗   -->
<div id="popWindow" class="popWindow" style="display: none;" catchtouchmove="preventTouchMove">
	<div class="head-box clearfix" >
		<a href="#" onclick="closeDiv()" class="fr" style="text-decoration:none;  cursor:pointer; line-height: 30px">
			X
		</a>
	</div>
	<div class="body-box">
	</div>
</div>
<script>
    function closeDiv() {
        document.getElementById("totalBody").style.overflow="";
        document.getElementById('popWindow').style.display = "none";
        document.getElementById('maskLayer').style.display = "none";
    }
</script>
<div id="maskLayer" class="maskLayer" style="display:none;"></div>
<script type="text/javascript" src="${root}/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${root}/resources/js/kkpage.js"></script>
<script type="text/javascript" src="${root}/resources/js/bootbox.min.js"></script>
<script type="text/javascript" src="${root}/resources/js/pintuer.js"></script>
<script type="text/javascript">
    var currentPage = 1;
    function loadData(page) {
        currentPage = page;
        $("#table-infoBody").html('<tr><td  colspan="10" class="center"><img style="height:365px;" src="${root}/resources/images/loading.gif"></td></tr>');
        $.post('${root}/admin/log/list',{
            currentPage : page,
            executorname: $("#executorname").val()
        }, function(data) {
            $("#table-infoBody").html("");
            $("#kkpage").html("");
            if (data.dataList != null && data.dataList.length > 0) {
                for (var i = 0; i < data.dataList.length; i++) {
                    $("#table-infoBody")
                        .append("<tr><td style='text-align:center;'>"+ ((data.currentPage - 1) * 7 + (i + 1))+ "</td>"+
                            "<td style='text-align:center;'>"+data.dataList[i].executorname+"</td>"+
                            "<td style='text-align:center;'>"+data.dataList[i].requestip+"</td>"+
                            "<td style='text-align:center;'>"+data.dataList[i].requestdesc+"</td>"+
                            "<td style='text-align:center;'>"+data.dataList[i].executetime +"</td>"+
                            "<td style='text-align:center;'>"+data.dataList[i].requestime+"</td>"+
                            "<td><a href='javascript:void(0)'  data-id='"+data.dataList[i].id+"' class='button border-info'>查看详细信息</td>"+
                            "</td></tr>");
                }
            }
            createPageInfo(page,data.pageSize,data.pageCount,data.rowCount,goToPage);
            // 将查询条件回显
            $("#executorName").val(data.executorName);
        }, "json");
    }

    //init
    function createPageInfo(currentPage,pageSize,pageCount,recordCount,callbackFunction){
        var totalPage = pageCount;
        var totalRecords = recordCount;
        var pageNo = currentPage;
        if(!pageNo){
            pageNo = 1;
        }
        $("#kkpager").html("");
        kkpager.inited = false;
        kkpager.generPageHtml({
            pno : pageNo,
            total : totalPage,
            mode : 'click',
            totalRecords : totalRecords,
            click : function(n){
                callbackFunction(n);
                kkpager.selectPage(n)
            }
        });
    }

    function goToPage(n){
        loadData(n);
    }

    loadData(currentPage);

    function changesearch(){
        loadData(1);
    }

    $(function (){
        $("body").on("click",".border-info",function (){
            document.getElementById("totalBody").style.overflow="hidden";
            document.getElementById('popWindow').style.display = "block";
            document.getElementById('maskLayer').style.display = "block";
            var id=$(this).attr("data-id");
            $.get(
                "${root}/admin/log/details",
                {id:id},
                function (result){
                    if(result.code==200){
                        $(".body-box").html("");
                        $(".body-box").append("<table id=\"booksTable\" class=\"table table-bordered btn-lg col-sm-7\"\n" +
                            "                   style=\"text-align: center\">\n" +
                            "                <tr>\n" +
                            "                    <th colspan=\"2\" style=\"text-align: center\">日志详情</th>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <th style=\"text-align: right; padding-right: 20px\">操作管理员</th>\n" +
                            "                    <td>"+result.log.executorname+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <th style=\"text-align: right; padding-right: 20px;\">请求时间</th>\n" +
                            "                    <td readonly=\"readonly\">"+result.log.requestime+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <th style=\"text-align: right; padding-right: 20px;\">请求描述</th>\n" +
                            "                    <td readonly=\"readonly\">"+result.log.requestdesc+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <th class=\"col-sm-3\"\n" +
                            "                        style=\"text-align: right; padding-right: 20px\">方法名</th>\n" +
                            "                    <td readonly=\"readonly\">"+result.log.executemethodname+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <th style=\"text-align: right; padding-right: 20px;\">参数</th>\n" +
                            "                    <td readonly=\"readonly\">"+result.log.executeargs+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <th style=\"text-align: right; padding-right: 20px;\">执行时间(单位：毫秒)</th>\n" +
                            "                    <td readonly=\"readonly\">"+result.log.executetime+"</td>\n" +
                            "                </tr>\n" +
                            "                <tr>\n" +
                            "                    <th style=\"text-align: right; padding-right: 20px;\">请求IP地址</th>\n" +
                            "                    <td readonly=\"readonly\">"+result.log.requestip+"</td>\n" +
                            "                </tr>\n" +
                            "            </table>");
                    }
                },
                "json"
            );
        });
    })
</script>
</body>
</html>