<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>淘多多-首页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/shop/res/static/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/shop/res/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/page/myPagination.css?t=4" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/shop/res/layui/layui.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<style type="text/css">
</style>
</head>
<body>
<div class="site-nav-bg">
<c:if test="${login==null }">
<div class="site-nav w1200">
<p class="sn-back-home">
<i class="layui-icon layui-icon-home"></i>
<a href="${pageContext.request.contextPath}/commonapi/index">首页</a>
</p>
<div class="sn-quick-menu">
<div class="login" id="loginlocal"><a href="${pageContext.request.contextPath}/commonapi/user_login">登录</a></div>
<div class="sp-cart"><a href="${pageContext.request.contextPath}/commonapi/user_info_regist">注册</a></div>
</div>
</div>
</c:if>
<c:if test="${login!=null }">
<div class="site-nav w1200">
<p class="sn-back-home">
<i class="layui-icon layui-icon-home"></i>
<a href="${pageContext.request.contextPath}/commonapi/index">首页</a>
</p>
<div class="sn-quick-menu">
<div class="login" id="loginlocal"><a href="${pageContext.request.contextPath}/commonapi/user_logout">退出</a></div>
<div class="sp-cart" style="margin-left:15px;"><a href="${pageContext.request.contextPath}//user/index">个人中心</a></div>
<div class="sp-cart" style="margin-left:15px;"><a href="${pageContext.request.contextPath}/commonapi/index/order_pay">待付款订单</a></div>
</div>
</div>
</c:if>
</div>
<div class="header">
<div class="headerLayout w1200">
<div class="headerCon">
<h1 class="mallLogo" >
<a href="${pageContext.request.contextPath}/commonapi/index" title="淘多多">
淘多多
</a>
</h1>
</div>
</div>
</div>
<div class="content content-nav-base commodity-content">
<div class="main-nav">
<div class="inner-cont0">
<div class="inner-cont1 w1200">
<div class="inner-cont2">
<a href="${pageContext.request.contextPath}/commonapi/index" class="">首页</a>
<a href="${pageContext.request.contextPath}/commonapi/index/query_list" class="active">所有商品</a>
<a href="${pageContext.request.contextPath}/commonapi/index/tg/query_list" class="active">团购商品</a>
</div>
</div>
</div>
</div>
<div class="floors">
<div class="sk">
<div class="sk_inner w1200">
<div class="sk_hd">
<a href="javascript:;">
<img src="${pageContext.request.contextPath}/static/shop/res/static/img/img1.png">
</a>
</div>
<div class="sk_bd">
<div class="layui-carousel" id="test1" lay-anim="" lay-indicator="none" lay-arrow="always" style="width: 100%; height: 298px;">
<div carousel-item="">
<c:set var="count" value="0" />
<c:forEach var="item" items="${pl}">
<c:if test="${count==0}">
<div class="item-box">
</c:if>
<c:if test="${count!=0}">
<div class="item-box  layui-this">
</c:if>
<c:forEach var="item2" items="${item}">
<div class="item">
<a href="${pageContext.request.contextPath}/commonapi/index/detail?id=${item2.id}"><img src="${item2.img}" style="width:200px;height:200px;"></a>
<div class="title">${item2.title}</div>
<div class="price">
<span>￥${item2.price}</span>
<!--                       <del>￥99.00</del> -->
</div>
</div>
</c:forEach>
</div>
</c:forEach> 
</div>
<div class="layui-carousel-ind"><ul><li class=""></li><li class="layui-this"></li></ul></div><button class="layui-icon layui-carousel-arrow" lay-type="sub"></button><button class="layui-icon layui-carousel-arrow" lay-type="add"></button>
</div>
</div>
</div>
</div>
</div>
<div class="product-list-box" id="product-list-box">
<div class="product-list-cont w1200">
<h4>更多推荐</h4>
<div class="product-item-box layui-clear">
<c:forEach var="item" items="${pl2}">
<div class="list-item" style="height:330px;">
<a href="${pageContext.request.contextPath}/commonapi/index/detail?id=${item.id}"><img src="${item.img }" style="width:200px;height:200px;"></a>
<p>${item.title}</p>
<span>￥${item.price}</span> 
</div>
</c:forEach>
</div>
</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/static/shop/res/static/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
<script>
layui.config({
	base: '${pageContext.request.contextPath}/static/shop/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
	}).use(['mm','carousel'],function(){
		var carousel = layui.carousel,
		mm = layui.mm;
		var option = {
				elem: '#test1'
				,width: '100%' //设置容器宽度
				,arrow: 'always'
				,height:'298' 
				,indicator:'none'
				}
		carousel.render(option);
		});
</script>
</body>
</html>
