<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="uri" value="${pageContext.request.contextPath}" />
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/skin/green/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
<style type="text/css">
.btnStyle{
margin-left:8px;
margin-top:8px
}
.loadingModel {
position: absolute;
top: 0;
left: 0;
background-color: rgba(9, 9, 9, 0.63);
width: 100%;
height: 100%;
z-index: 1000;
}
.loading-content {
width: 50%;
text-align: center;
background: #ffffff;
border-radius: 6px;
line-height: 30px;
z-index: 10001;
}
</style>
<!--[if IE 6]>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>团购订单</title>
</head>
<body>
<div id="loadingDiv"></div>
<div id="bodyModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<div class="modal-content radius">
<div class="modal-header">
<h3 class="modal-title" id="bodyModalTile"></h3>
<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
</div>
<div class="modal-body" id="bodyModalContent">
</div>
<div class="modal-footer">
<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
</div>
</div>
</div>
</div>
<nav class="breadcrumb"><i class="Hui-iconfont"></i>团购订单<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont"></i></a></nav>
<div class="page-container">
<div style="display:inline;margin-top:30px"><span style="width:200px;margin-left:50px;">订单编号</span>
<input type="text" class="input-text"  style="width:250px;display:inline"  placeholder="请输入订单编号进行查询" id="orderNo">
</div>
<div style="display:inline;margin-top:30px"><span style="width:200px;margin-left:50px;">团购标题</span>
<input type="text" class="input-text"  style="width:250px;display:inline"  placeholder="请输入团购标题进行查询" id="tgTitle">
</div>
<div style="display:inline;margin-top:30px"><span style="width:200px;margin-left:50px;">团购订单状态</span>
<select  id="tgOrderStatus" style="height:30px;width:250px;display:inline" >
<option value="">全部</option>
<c:forEach items="${tgOrderStatusList}" var="item">
<option value="${item.id}">${item.name}</option>
</c:forEach>
</select>
</div>
<div style="margin-top:30px;"></div>
<div style="display:inline;margin-top:30px"><span style="width:200px;margin-left:50px;">收货人</span>
<input type="text" class="input-text"  style="width:250px;display:inline"  placeholder="请输入收货人进行查询" id="userContactName">
</div>
<div style="display:inline;margin-top:30px"><span style="width:200px;margin-left:50px;">收货人手机号</span>
<input type="text" class="input-text"  style="width:250px;display:inline"  placeholder="请输入收货人手机号进行查询" id="contactCel">
</div>
<button type="button" onclick="ajaxList(1);" style="margin-left:30px" class="btn btn-success" ><i class="Hui-iconfont"></i> 查询</button>
<div class="cl pd-5 bg-1 bk-gray mt-20">
<span class="l" id="globalBtns">
</span>
<span id="batchUpdateDiv">
</span>
</div>
<table class="table table-border table-bordered table-hover table-bg table-sort" style="">
<thead>
<tr style="text-align:center">
<th>订单编号</th>
<th>团购标题</th>
<th>团购价格</th>
<th>团购数量</th>
<th>总金额</th>
<th>团购订单状态</th>
<th>发货物流</th>
<th>收货人</th>
<th>收货人手机号</th>
<th>收货人城市</th>
<th>收货人地址</th>
<th>团长</th>
<th>创建时间</th>
<th style="width:200px;">操作</th>
</tr>
</thead>
<tbody id="tg_order_info_body">
</tbody>
</table>
<div id="tg_order_info_bar" class="pagination" style="margin-top:20px;">
</div>
<div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=7930"></script>
<script type="text/javascript">
$(function(){
	ajaxList(1);
	});
	function ajaxList(page) {
		var orderNo = $("#orderNo").val();
		var tgTitle = $("#tgTitle").val();
		var tgOrderStatus = $("#tgOrderStatus").val();
		var userContactName = $("#userContactName").val();
		var contactCel = $("#contactCel").val();
		showLoading('${pageContext.request.contextPath}/static/common/loading.gif');
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/tz/tg_order_info/queryList",
			data : {
				"page":page,
				"orderNo":orderNo,
				"tgTitle":tgTitle,
				"tgOrderStatus":tgOrderStatus,
				"userContactName":userContactName,
				"contactCel":contactCel
				},
				success : function(result) {
					hideLoading();
					var rows = result.list;//得到数据列
					var total = result.count;//得到数据总数
					lastPage=result.totalPage;
					totalCount=total;
					var html = '';
					for (var i = 0; i < rows.length; i++) {
						html += '<tr>' ;
						var orderNoVal=setNullToEmpty(rows[i].tgOrderInfo.orderNo);
						html+='<td>'+ orderNoVal+'</td>';
						var tgTitleVal=setNullToEmpty(rows[i].tgOrderInfo.tgTitle);
						html+='<td>'+ tgTitleVal+'</td>';
						var tgPriceVal=setNullToEmpty(rows[i].tgOrderInfo.tgPrice);
						html+='<td>'+ tgPriceVal+'</td>';
						var numVal=setNullToEmpty(rows[i].tgOrderInfo.num);
						html+='<td>'+ numVal+'</td>';
						var totalAmountVal=setNullToEmpty(rows[i].tgOrderInfo.totalAmount);
						html+='<td>'+ totalAmountVal+'</td>';
						var tgOrderStatusVal=setNullToEmpty(rows[i].tgOrderStatusStr);
						if(rows[i].tgOrderInfo.tgOrderStatus=='1'){
							tgOrderStatusVal ='<span class="badge badge-default radius">'+tgOrderStatusVal+'</span>'}
						if(rows[i].tgOrderInfo.tgOrderStatus=='2'){
							tgOrderStatusVal ='<span class="badge badge-warning radius">'+tgOrderStatusVal+'</span>'}
						if(rows[i].tgOrderInfo.tgOrderStatus=='3'){
							tgOrderStatusVal ='<span class="badge badge-secondary radius">'+tgOrderStatusVal+'</span>'}
						if(rows[i].tgOrderInfo.tgOrderStatus=='4'){
							tgOrderStatusVal ='<span class="badge badge-success radius">'+tgOrderStatusVal+'</span>'}
						if(rows[i].tgOrderInfo.tgOrderStatus=='5'){
							tgOrderStatusVal ='<span class="badge badge-danger radius">'+tgOrderStatusVal+'</span>'}
						html+='<td>'+tgOrderStatusVal+'</td>';
						var trainMsgVal=setNullToEmpty(rows[i].tgOrderInfo.trainMsg);
						html+='<td>'+ trainMsgVal+'</td>';
						var userContactNameVal=setNullToEmpty(rows[i].tgOrderInfo.userContactName);
						html+='<td>'+ userContactNameVal+'</td>';
						var contactCelVal=setNullToEmpty(rows[i].tgOrderInfo.contactCel);
						html+='<td>'+ contactCelVal+'</td>';
						var contactCityVal=setNullToEmpty(rows[i].tgOrderInfo.contactCity);
						html+='<td>'+ contactCityVal+'</td>';
						var contactAddressVal=setNullToEmpty(rows[i].tgOrderInfo.contactAddress);
						html+='<td>'+ contactAddressVal+'</td>';
						var tzIdVal=setNullToEmpty(rows[i].tzIdStr);
						html+='<td>'+ tzIdVal+'</td>';
						var createTimeVal=setNullToEmpty(rows[i].tgOrderInfo.createTime);
						html+='<td>'+ createTimeVal+'</td>';
						html+='<td>';
						if(rows[i].tgOrderInfo.tgOrderStatus=='6'){
							html+='<a href="${pageContext.request.contextPath}/tz/tg_order_info/fh?id='+rows[i].tgOrderInfo.id+'" class="btn btn-primary  radius btnStyle">发货</a>';
							}
						html+='</td>';
						html+='</tr>';
						}
					if (rows.length == 0) {
						html += '<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>无数据</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';
						}
					$("#tg_order_info_body").html(html);
					new myPagination({
						id: 'tg_order_info_bar',
						curPage:page, //初始页码
						pageTotal: result.totalPage, //总页数
						pageAmount: 10,  //每页多少条
						dataTotal: total, //总共多少条数据
						pageSize: 5, //可选,分页个数
						showPageTotalFlag:true, //是否显示数据统计
						showSkipInputFlag:false, //是否支持跳转
						getPage: function (page) {
							ajaxList(page);
							}
					})
					}
				});
		}
	function gotoPage(e){
		var pageName = $(e).attr("page-name");
		var url = $(e).attr("data-url");
		creatIframe(url,pageName);
		}
</script>
</body>
</html>
