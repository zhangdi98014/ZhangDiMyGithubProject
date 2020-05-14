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
<c:set var="uri" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
var uri='${uri}';
</script>
<!--[if lt IE 9]>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/html5shiv.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/icheck/icheck.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/webupload/webuploader.css">
<style type="text/css">
.loadingModel {
position: absolute;
top: 0;
left: 0;
display: none;
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
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title></title>
</head>
<body>
<div id="loadingDiv"></div>
<div id="imgModal"></div>
<div class="page-container">
<div class="row cl" id="proIdParentContent" style="margin-top:20px;margin-left:20px;" >
<label class="form-label col-xs-4 col-sm-2">
原商品
</label>
<div class="formControls col-xs-8 col-sm-9">
<select  id="proId" style="height:30px;width:500px;display:inline" >
<c:forEach items="${proInfoList}" var="item">
<c:if test="${item.id==data.proId}">
<option value="${item.id}" selected>${item.name}</option>
</c:if>
<c:if test="${item.id!=data.proId}">
<option value="${item.id}">${item.name}</option>
</c:if>
</c:forEach>
</select>
</div>
</div>
<div class="row cl" id="tgImgParentContent" style="margin-top:20px;margin-left:20px;" >
<label class="form-label col-xs-4 col-sm-2">
团购宣传图
</label>
<div class="formControls col-xs-8 col-sm-9">
<div class="imgUpload" tip="请上传团购宣传图，数量不超过1" red-tip=""   upload-num="1" init-val="${data.tgImg}" upload-type="1" id="tgImg"></div>
</div>
</div>
<div class="row cl" id="tgTitleParentContent" style="margin-top:20px;margin-left:20px;" >
<label class="form-label col-xs-4 col-sm-2">
团购标题
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text"  style="width:500px;display:inline" value="${data.tgTitle}" placeholder="请输入团购标题" id="tgTitle">
</div>
</div>
<div class="row cl" id="tgPriceParentContent" style="margin-top:20px;margin-left:20px;" >
<label class="form-label col-xs-4 col-sm-2">
团购价格
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text"  style="width:500px;display:inline" value="${data.tgPrice}" placeholder="请输入团购价格（请输入数字）" id="tgPrice">
</div>
</div>
<div class="row cl" id="tgNumParentContent" style="margin-top:20px;margin-left:20px;" >
<label class="form-label col-xs-4 col-sm-2">
团购数量
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text"  style="width:500px;display:inline" value="${data.tgNum}" placeholder="请输入团购数量（请输入数字）" id="tgNum">
</div>
</div>
<div class="row cl" id="tgStartTimeParentContent" style="margin-top:20px;margin-left:20px;" >
<label class="form-label col-xs-4 col-sm-2">
团购开始时间
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text Wdate"  readonly="readonly"  style="width:500px;display:inline" value="${data.tgStartTime}"  onFocus="WdatePicker({startDate: '%y-%M-%d 00:00:00' ,dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate: true })"  placeholder="请输入团购开始时间" id="tgStartTime">
</div>
</div>
<div class="row cl" id="tgEndTimeParentContent" style="margin-top:20px;margin-left:20px;" >
<label class="form-label col-xs-4 col-sm-2">
团购结束时间
</label>
<div class="formControls col-xs-8 col-sm-9">
<input type="text" class="input-text Wdate"  readonly="readonly"  style="width:500px;display:inline" value="${data.tgEndTime}"  onFocus="WdatePicker({startDate: '%y-%M-%d 00:00:00' ,dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate: true })"  placeholder="请输入团购结束时间" id="tgEndTime">
</div>
</div>
</div>
<hr>
<div class="page-container">
<div class="row cl" style="margin-top:20px;">
<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
<button onClick="submitData();" class="btn btn-primary radius" type="button"><i class="Hui-iconfont"></i> 保存并提交</button>
<button onClick="javascript:history.back(-1);" class="btn btn-default radius" type="button">返回</button>
</div>
</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/hui/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/utils/listutils.js?v=9839"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/webupload/webuploader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/webupload/upload.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.css?d=129339" />
<script type="text/javascript" src="${pageContext.request.contextPath}/static/common/selectSearch/jquery.searchableSelect.js?d=1293393"></script>
<script type="text/javascript">
$(function(){
	$('#proId').next().remove();
	$('#proId').searchableSelect();
	createFileUpload('${pageContext.request.contextPath}');
	})
	function submitData(){
	var proId= $('#proId').val();
	var tgImg=getUploadFileStr('tgImg');
	var tgTitle= $('#tgTitle').val();
	var tgPrice= $('#tgPrice').val();
	var tgNum= $('#tgNum').val();
	var tgStartTime= $('#tgStartTime').val();
	var tgEndTime= $('#tgEndTime').val();
	if(tgPrice!=''){
		if(isNum(tgPrice)==false){
			alert("团购价格必须填入数字");
			return;
			}
		}
	if(tgNum!=''){
		if(isIntNum(tgNum)==false){
			alert("团购数量必须填入整数");
			return;
			}
		}$.ajax({
			type: 'post',
			url: '${pageContext.request.contextPath}/tz/tg_info/update_submit',
			data:{
				"id":'${data.id}',
				"proId":proId,
				"tgImg":tgImg,
				"tgTitle":tgTitle,
				"tgPrice":tgPrice,
				"tgNum":tgNum,
				"tgStartTime":tgStartTime,
				"tgEndTime":tgEndTime
				},
				success: function(result) {
					if(result.code == 0){
						alert(result.msg);
						}else{
							alert(result.msg);
							self.location=document.referrer;
							}
					}
				});
		}
</script>
</body>
</html>
