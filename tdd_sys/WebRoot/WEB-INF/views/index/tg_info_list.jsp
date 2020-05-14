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
<div class="mallSearch">
<div class="searchBorder" >
<input type="text" name="searchWord" id="searchWord"  required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入搜索关键词">
<button class="layui-btn" lay-submit lay-filter="formDemo" onclick="search()">
<i class="layui-icon layui-icon-search"></i>
</button>
<input type="hidden" name="" value="">
</div>
</div>
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
<div class="commod-cont-wrap">
<div class="commod-cont w1200 layui-clear">
<div class="right-cont-wrap">
<div class="right-cont">
<div class="cont-list layui-clear" id="list-cont">
</div>
<div id="pro_info_bar" class="box-footer clearfix pagination" style="margin-top:20px;"></div>
</div>
</div>
</div>
</div>
</div>
<script src="${pageContext.request.contextPath}/static/shop/res/static/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/page/myPagination.js"></script>
<script>
$(function(){
	ajaxList(1);	
	})
	function search(){
	ajaxList(1);
	}
	function ajaxList(page) {
		//1.默认搜索，2.排序按钮
		var searchWord = $("#searchWord").val();
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/commonapi/index/tg/search",
			data : {
				"page":page,
  				"searchWord":searchWord,
  				},
  				success : function(result) {
  					var rows = result.data;//得到数据列
  					var pl2 = result.pl2;
  					var html = '';
  					for (var i = 0; i < rows.length; i++) {
  						html+='<div class="item">'
  		                +'<div class="img">'
  		                +'<a href="${pageContext.request.contextPath}/commonapi/index/tg/detail?id='+rows[i].id+'"><img src="'+rows[i].img+'" style="width:280px;height:230px;"></a>'
  		                +'</div>';
  		                html+='<div class="text">';
  		                html+='<p class="title">'+rows[i].title+'</p>';
  		                if(rows[i].pStatus==4){
  		                	html+='<p class="layui-badge layui-bg-orange">'+rows[i].tgStatus+'</p>';  	
  		                	}
  		                if(rows[i].pStatus==5){
  		                	html+='<p class="layui-badge layui-bg-green">'+rows[i].tgStatus+'</p>';  	
  		                	}
  		                html+='<p class="price">';
  		                html+='<span class="pri">￥'+rows[i].price+'元</span>';
  		                //html+='<span class="nub">类型</span>';
  		                html+='</p>';
  		                //html+='<p class="price"><span class="nub">销量：xxxx</span></p>';
  		                html+='</div>';
   		              	html+='</div>';
   		              	}
  					$("#list-cont").html(html);	
  					new myPagination({
  						id: 'pro_info_bar',
  						curPage:page, //初始页码
  						pageTotal: result.totalPage, //总页数
  						pageAmount: 9,  //每页多少条
  						dataTotal: result.count, //总共多少条数据
  						pageSize: 9, //可选,分页个数
  						showPageTotalFlag:true, //是否显示数据统计
  						showSkipInputFlag:false, //是否支持跳转
  						getPage: function (page) {
  							ajaxList(page);
  							}
  					})
  					}
  				});
		}
</script>
</body>
</html>
