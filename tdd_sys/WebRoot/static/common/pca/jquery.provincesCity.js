﻿/**
 * jQuery :  城市联动插件
 * @author   XiaoDong <cssrain@gmail.com>
 *			 http://www.cssrain.cn
 * @example  $("#test").ProvinceCity();
 * @params   暂无
 */
$.fn.ProvinceCity = function(pId,cId,cId2){
	var _self = this;
	//定义3个默认值
	_self.data("province",["请选择", "请选择"]);
	_self.data("city1",["请选择", "请选择"]);
	_self.data("city2",["请选择", "请选择"]);
	//插入3个空的下拉框
	_self.append("<select style='margin-left:10px; width:100px;height:30px;display:inline' id='"+pId+"'></select>");
	_self.append("<select style='margin-left:10px; width:100px;height:30px;display:inline' id='"+cId+"'></select>");
	_self.append("<select style='margin-left:10px; width:100px;height:30px;display:inline' id='"+cId2+"'></select>");
	//分别获取3个下拉框
	var $sel1 = _self.find("select").eq(0);
	var $sel2 = _self.find("select").eq(1);
	var $sel3 = _self.find("select").eq(2);
	//默认省级下拉
	if(_self.data("province")){
		$sel1.append("<option value='"+_self.data("province")[1]+"'>"+_self.data("province")[0]+"</option>");
	}
	$.each( GP , function(index,data){
		$sel1.append("<option value='"+data+"'>"+data+"</option>");
	});
	//默认的1级城市下拉
	if(_self.data("city1")){
		$sel2.append("<option value='"+_self.data("city1")[1]+"'>"+_self.data("city1")[0]+"</option>");
	}
	//默认的2级城市下拉
	if(_self.data("city2")){
		$sel3.append("<option value='"+_self.data("city2")[1]+"'>"+_self.data("city2")[0]+"</option>");
	}
	//省级联动 控制
	var index1 = "" ;
	$sel1.change(function(){
		//清空其它2个下拉框
		$sel2[0].options.length=0;
		$sel3[0].options.length=0;
		index1 = this.selectedIndex;
		if(index1==0){	//当选择的为 “请选择” 时
			if(_self.data("city1")){
				$sel2.append("<option value='"+_self.data("city1")[1]+"'>"+_self.data("city1")[0]+"</option>");
			}
			if(_self.data("city2")){
				$sel3.append("<option value='"+_self.data("city2")[1]+"'>"+_self.data("city2")[0]+"</option>");
			}
		}else{
			$sel2.append("<option value='"+_self.data("city1")[1]+"'>"+_self.data("city1")[0]+"</option>");
			$.each( GT[index1-1] , function(index,data){
				$sel2.append("<option value='"+data+"'>"+data+"</option>");
			});
			$sel3.append("<option value='"+_self.data("city2")[1]+"'>"+_self.data("city2")[0]+"</option>");
			$.each( GC[index1-1][0] , function(index,data){
				$sel3.append("<option value='"+data+"'>"+data+"</option>");
			})
		}
	}).change();
	//1级城市联动 控制
	var index2 = "" ;
	$sel2.change(function(){
		$sel3[0].options.length=0;
		index2 = this.selectedIndex-1;
		$sel3.append("<option value='"+_self.data("city2")[1]+"'>"+_self.data("city2")[0]+"</option>");
		$.each( GC[index1-1][index2] , function(index,data){
			$sel3.append("<option value='"+data+"'>"+data+"</option>");
		})
	});
	return _self;
};

function initPca(domId,val){
	  //省市区组件初始化
	var pcaDiv = $(".pcaDiv");
	for(var i=0;i<pcaDiv.length;i++){
		var dataName = $(pcaDiv[i]).attr("data-name");
		if(domId==dataName){
			$(pcaDiv[i]).ProvinceCity(dataName+"Province",dataName+"City1",dataName+"City2");
			if(val!=null&&val!=''){
				var tmp = val.split(" ");
				if(tmp.length>=1){
					$("#"+dataName+"Province").val(tmp[0].trim());
					$("#"+dataName+"Province").change();
				}
				if(tmp.length>=2){
					$("#"+dataName+"City1").val(tmp[1].trim());
					$("#"+dataName+"City1").change();
				}
				if(tmp.length>=3){
					$("#"+dataName+"City2").val(tmp[2].trim());
				}
			}
		}
	}
}

function getPcaVal(domId){
	var pcaDiv = $(".pcaDiv");
	for(var i=0;i<pcaDiv.length;i++){
		var dataName= $(pcaDiv[i]).attr("data-name");
		if(dataName==domId){
			var val="";
			var provinceName= $("#"+domId+"Province").val();
			var cityName1= $("#"+domId+"City1").val();
			var cityName2= $("#"+domId+"City2").val();
			if(provinceName!=''&&provinceName!='请选择'){
				val+=provinceName;
				if(cityName1!=''&&cityName1!='请选择'){
					val+=" "+cityName1;
					if(cityName2!=''&&cityName2!='请选择'){
						val+=" "+cityName2;
					}
				}
			}
			return val;
		}
		
	}
	return "";
}
