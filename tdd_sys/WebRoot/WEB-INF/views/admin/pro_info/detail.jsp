<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>商品-详情页</title>
</head>
<body>
<div style="margin-top:50px;margin-left:50px;"><a href="javascript:void(0)" onclick="javascript:history.back(-1);"  class="btn btn-success radius">《《返回</a></div>
<div class="page-container">
<table class="table table-border table-bordered table-bg mt-20">
<thead>
<tr>
<th colspan="2" scope="col">商品-详情页</th>
</tr>
</thead>
<tbody>
<tr>
<th width="30%">商品大图</th>
<th width="30%"><img src="${detail.proInfo.proImg}" style="width:200px" /></th>
</tr>
<tr>
<th width="30%">商品标题</th>
<th width="30%">${detail.proInfo.title}</th>
</tr>
<tr>
<th width="30%">商品类型</th>
<th width="30%" id=proTypeIdStr>${detail.proTypeIdStr}</th>
</tr>
<tr>
<th width="30%">商品价格</th>
<th width="30%">${detail.proInfo.proPrice}</th>
</tr>
<tr>
<th width="30%">商品库存</th>
<th width="30%">${detail.proInfo.sctockNum}</th>
</tr>
<tr>
<th width="30%">销量</th>
<th width="30%">${detail.proInfo.saleNum}</th>
</tr>
<tr>
<th width="30%">商品详情</th>
<th width="30%">${detail.proInfo.proDetail}</th>
</tr>
</tbody>
</table>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=#随机码#"></script>
<script type="text/javascript">
$(function(){
	
})
</script>
</body>
</html>
