<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta charset="utf-8">
<title>提交订单——结算页</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/order_pay/css/index.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/order_pay/css/ziy.css">
<!--  <script src="js/index.js" ></script>  -->
<!-- <script type="text/javascript" src="js/jquery1.42.min.js"></script> -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/order_pay/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/order_pay/js/jquery.SuperSlide.2.1.1.source.js"></script>
</head>
<body>
<!--提交订单——结算页-->
<div class="beij_center">
<div class="dengl_logo">
<div>
<h1>结算页</h1>
</div>
</div>
</div>
<div class="beij_center">
<div class="checkout-tit">
<span class="tit-txt">填写并核对订单信息</span>
</div>
<div class="checkout_steps">
<div class="step-tit">
<h3>待付款订单</h3> 
</div>
<div class="shopping_list">
<div class="goods_list" style="width:100%">
<c:forEach  var="item" items="${ol}">
<div class="goods_list_neik">
<div class="goods_item">
<div class="p_img"><a href="#"><img src="${item.img }"></a></div>
<div class="goods_msg">
<div class="p_name">
<a href="#">${item.title}</a>
</div>
<div class="p_price">
<span class="jq_price">￥ ${item.price }</span>
<span>x${item.num }</span>
<span>总共:${item.totalAmount}元</span>
<span><button onclick="delOrder(this)" data-id="${item.id}">删除</button></span>
</div>
</div>
</div>
</div>
</c:forEach>
</div>
</div>
</div>
<!--收费明细-->
<div class="order_summary">
<div class="qianq_mx">
<div class="jiaq_meih">
<span class="xiangq_leib">数量：<em class="goumai_ges">${totalNum }</em> ，总金额：</span>
<em class="goum_zongj">￥${totalAmount}</em>
</div>
</div>
</div>
<div class="trade_foot_detail_com">
<div class="dsgs">
<div class="qianq_mx">
<div class="jiaq_meih">
<span class="xiangq_leib"> 应付总额：</span>
<em class="goum_zongj zhongf_jine">￥${totalAmount }</em>
</div> 
</div>
</div>
</div>
<div class="tij_dingd_ann">
<a href="javascript:void(0)" onclick="submitOrder()">提交订单</a>
</div>
</div>
<script type="text/javascript">
function submitOrder(){
	if('${totalNum}'=='0'){
		alert("您没有任何待付款商品");
		return;
		}
	window.location.href="${pageContext.request.contextPath}/commonapi/index/order_pay/goPayOrderPage?amount=${totalAmount}";
	}
	function delOrder(e){
		var id = $(e).attr("data-id");
		$.ajax({
			type : 'get',
			url : "${pageContext.request.contextPath}/commonapi/index/order_pay/delOrder",
			data : {
				"id":id
				},
				success : function(result) {
					if(result.code==1){
						alert(result.msg);
						window.location.reload();
						}else{
							alert(result.msg);	
							}
					}
				});
		}
	$(function(){
		$(".shiq_1 ul li").hide().first().show()
		$(".cur_e p").hide().first().show()
		$(".cur_e p:first").click(
				function(){
					$(".shiq_1 ul li").show()
					$(".cur_e p").hide().last().show()
					}
				)
				$(".cur_e p:last").click(
						function(){
							$(".shiq_1 ul li").hide().first().show()
							$(".cur_e p").hide().first().show()
							}
						)
						})
						$(function(){
							$(".shiq_2 ul li").hide().first().show()
							$(".cur_e_1 p").hide().first().show()
							$(".cur_e_1 p:first").click(
									function(){
										$(".shiq_2 ul li").show()
										$(".cur_e_1 p").hide().last().show()
										}
									)
									$(".cur_e_1 p:last").click(
											function(){
												$(".shiq_2 ul li").hide().first().show()
												$(".cur_e_1 p").hide().first().show()
												}
											)
											})
											//cur 
</script>
</body>
</html>
