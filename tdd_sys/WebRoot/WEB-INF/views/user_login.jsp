<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>淘多多-用户登录</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/layui/login/img/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/login/css/login.css">
<style>
.codeBtn{
float:right;
color:blue;
top:7px;
left:75%;
z-index:99;
}
</style>
</head>
<body>
<div class="layui-carousel video_mask" id="login_carousel">
<div carousel-item>
<div class="carousel_div1"></div>
<div class="carousel_div2"></div>
<div class="carousel_div3"></div>
</div>
<div class="login layui-anim layui-anim-up">
<div class="layui-logo">
<p style="color:red">${msg}</p>
</div>
<fieldset class="layui-elem-field layui-field-title">
<legend class="text-white">淘多多-用户登录</legend>
</fieldset>
<div class="layui-form" >
<div class="layui-form-item  form_code">
<input id="name" name="name" type="text" placeholder="请输入登录名"   class="layui-input ">
</div>
<div class="layui-form-item  form_code">
<input id="password" name="password" type="password" placeholder="请输入密码"   class="layui-input ">
</div>
<div class="layui-form-item form_code">
<input type="text" name="imgCode" id="imgCode"  maxlength="6" placeholder="请输入图片验证码" autocomplete="off" class="layui-input">
<div class="code"><img name="codeImg" id="codeImg1" width="118" height="38"></div>
</div>
<a  style="color:white;float:left;left:10px;" href="${pageContext.request.contextPath}/commonapi/user_info_regist" onclick="" >注册用户</a>
</div>
<input type="hidden" id="loginType"  name="loginType" value="3">
<button class="login_btn layui-btn layui-btn-radius layui-btn-normal" onclick="submitForm()" >用户登录</button>
<hr class="layui-bg-gray">
<div class="layui-footer text-white">
<!-- 底部固定区域 -->
Copyright 淘多多
</div>
</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui/layui.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/login/js/login.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=26573"></script>
</body>
<script>
$(document).ready(function(e) {
	changeCode();
	$("#codeImg1").bind("click",changeCode);
	});
	function genTimestamp(){
		var time = new Date();
		return time.getTime();
		}
	function changeCode(){
		$("img[name='codeImg']").attr("src","${pageContext.request.contextPath}/commonapi/code?t="+genTimestamp());
		}
	function submitForm(){
		$.ajax({
			type: 'post',
			url: '${pageContext.request.contextPath}/commonapi/userSubmit',
			data: {
				'imgCode':$('#imgCode').val(),
				'name':$("#name").val(),
				'password':$("#password").val(),
				'loginType':$('#loginType').val()
				},
				success: function(result) {
					if(result.code==1){
						var lt = $('#loginType').val();
						if(lt=='3'){
							window.location.href="${pageContext.request.contextPath}/commonapi/index";
							}
						}else{
							alert(result.msg);
							}
					}
				});
		}
	$(function(){
		
	})
</script>
</html>
