<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>淘多多-详情页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/shop/res/static/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/shop/res/layui/css/layui.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/shop/res/layui/layui.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
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
<div class="content content-nav-base datails-content">
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
<div class="data-cont-wrap w1200">
<div class="product-intro layui-clear">
<div class="preview-wrap">
<a href="javascript:;"><img style="width:300px;height:300px;" src="${pro.img }" id="goodsmainimg"></a>
</div>
<div class="itemInfo-wrap">
<div class="itemInfo">
<div class="title">
<h4 id="goodstitle">${pro.title}</h4>
<c:if test="${pro.pStatus==4}">
<p class="layui-badge layui-bg-orange">${pro.tgStatus}</p> 
</c:if>
<c:if test="${pro.pStatus==5}">
<p class="layui-badge layui-bg-green">${pro.tgStatus}</p> 
</c:if>
</div>
<div class="summary" style="height:300px;">
<p class="activity"><span>价格</span><strong class="price"><i>￥</i><span id="priceShow">${pro.price }元</span></strong></p>
<p class="address-box"><span>团购数量</span><strong class="address">${pro.stockNum}</strong></p>
<p class="address-box"><span>开始时间</span><strong class="address">${pro.tgStartTime}</strong></p>
<p class="address-box"><span>结束时间</span><strong class="address">${pro.tgEndTime}</strong></p>
<p class="address-box"><span>已团购数量</span><strong class="address" style="color:red">${buyNum}</strong></p>
<p class="address-box"><span>倒计时</span><strong class="address" id="timeCal" style="color:red"></strong></p>
</div>
<div class="choose-attrs">
<div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont">
<span class="cut btn">-</span>
<input onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="" name="num" id="num" value="1">
<span class="add btn">+</span></div></div>
</div>
<div class="choose-btns">
<button class="layui-btn layui-btn-primary purchase-btn"  onclick="submitBuy()">立刻购买</button>
</div>
</div>
</div>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
<legend>商品详情</legend>
</fieldset> 
<p> ${p.proDetail}</p>
<div style="margin-top:400px"></div>
</div>
<div class="detail">
</div>
<br><br><br><br><br><br>
</div>
</div>
<script src="${pageContext.request.contextPath}/static/shop/res/static/checklogin.js"></script>
<script src="${pageContext.request.contextPath}/static/shop/res/static/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
function dateCount(){
	// 获取现在的时间
    var date = new Date();
    // 2018的第一天
    var until = new Date('${pro.tgEndTime}');
    // 计算时会发生隐式转换，调用valueOf()方法，转化成时间戳的形式
    var days = (until - date)/1000/3600/24; 
    // 下面都是简单的数学计算 
    var day = Math.floor(days);
    var hours = (days - day)*24;
    var hour = Math.floor(hours);
    var minutes = (hours - hour)*60;
    var minute = Math.floor(minutes);
    var seconds = (minutes - minute)*60;
    var second = Math.floor(seconds);
    var back = ''+day+'天'+hour+'小时'+minute+'分钟'+second+'秒';
    return back;
}
setInterval(function(){
	var text = dateCount();
    // show是一个节点
    $("#timeCal").html(text);
    },1000)
    layui.config({
    	base: '${pageContext.request.contextPath}/static/shop/res/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    	}).use(['mm','jquery'],function(){
    		var mm = layui.mm,$ = layui.$;
    		var cur = $('.number-cont input').val();
    		$('.number-cont .btn').on('click',function(){
    			if($(this).hasClass('add')){
    				cur++;
    				}else{
    					if(cur > 1){
    						cur--;
    						}  
    					}
    			$('.number-cont input').val(cur)
    			})
    			});
    			var layer;
    			layui.use(['layer'],function(){
    				layer =layui.layer
    				})
    				layui.use(['rate'], function(){
    					var starDiv = $(".star");
    					for(var i=0;i<starDiv.length;i++){
    						var score = $(starDiv[i]).attr("data-val");
    						var dataId = $(starDiv[i]).attr("data-id");
    						var rate = layui.rate;
    						rate.render({
    							elem: '#commentStar'+dataId
    							,value: score
    							,readonly: true
    							});
    						}
    					})
    					function submitBuy(){
    				var num = $("#num").val();
    				$.ajax({
    					type : 'get',
    					url : "${pageContext.request.contextPath}/commonapi/index/tg/detail/submitBuy",
    					data : {
    						"num":num,
    						"proId":"${pro.id}"
    						},
    						success : function(result) {
    							if(result.code==1){
    								window.location.href="${pageContext.request.contextPath}/commonapi/index/tg/order_pay"
    								}else{
    									if(result.msg.indexOf("尚未登录")!=-1){
    										alert(result.msg);	
    										window.location.href="${pageContext.request.contextPath}/commonapi/user_login"
    										}else{
    											alert(result.msg);
    											}
    									}
    							}
    						});
    				}
</script>
</body>
</html>
