function getStarByDomId(domId){
  return $("#"+domId+"Li").attr("data-default-index");
}
function initEvals(uri){
	var doms = $(".evalStar");
	for(var i=0;i<doms.length;i++){
		var id = $(doms[i]).attr("id");
		initStarEval(id,uri);
	}
}
function initStarEval(domId,uri){
	var initVal = $("#"+domId).attr("init-val");
	if(initVal==null||initVal==''||initVal=='null'||initVal==undefined||initVal=='undefined'){
		return;
	}
	var isFixed = $("#"+domId).attr("is-fixed");	
	if(initVal==undefined||initVal==''||initVal=='undefined'||initVal=='null'||initVal==null){
	  initVal=0;
	}
	if(isFixed==undefined||isFixed==''){
	  isFixed=1;
	}
	var html = '';
	html+=' <ul  id="'+domId+'Ul" style="list-style: none;padding:0;margin:0;">';
	html+=' 	<li id="'+domId+'Li"  data-default-index="'+initVal+'">';
	html+='		<span>';
	for(var i=0;i<initVal;i++){
		html+='		<img src="'+uri+'/img/x2.png">';
	}
	for(var i=0;i<5-initVal;i++){
		html+='		<img src="'+uri+'/img/x1.png">';
	}
	html+='		</span>';
	html+='   <em id="'+domId+'Level">'+byIndexLeve(initVal-1)+'</em>';
	html+=' 	</li>';
	html+=' </ul>';
	$("#"+domId).html(html);
	    //  星星数量
    var stars = [
        ['x2.png', 'x1.png', 'x1.png', 'x1.png', 'x1.png'],
        ['x2.png', 'x2.png', 'x1.png', 'x1.png', 'x1.png'],
        ['x2.png', 'x2.png', 'x2.png', 'x1.png', 'x1.png'],
        ['x2.png', 'x2.png', 'x2.png', 'x2.png', 'x1.png'],
        ['x2.png', 'x2.png', 'x2.png', 'x2.png', 'x2.png'],
    ];
	if(isFixed==1){
		  $("#"+domId+"Li").find("img").hover(function(e) {
        var obj = $(this);
        var index = obj.index();
        if(index < (parseInt($("#"+domId+"Li").attr("data-default-index")) -1)){
            return ;
        }
        var li = obj.closest("li");
        var star_area_index = li.index();
        for (var i = 0; i < 5; i++) {
            li.find("img").eq(i).attr("src",uri+"/img/" + stars[index][i]);//切换每个星星
        }
		$('#'+domId+'Level').html(byIndexLeve(index));
    }, function() {
    })
    $("#"+domId+"Li").hover(function(e) {
    }, function() {
        var index = $(this).attr("data-default-index");//点击后的索引
        index = parseInt(index);
        console.log("index",index);
		$('#'+domId+'Level').html(byIndexLeve(index-1));
       $('#'+domId+'Ul').find('li:eq(0)').find("img").attr("src",uri+"/img/x1.png");
        for (var i=0;i<index;i++){
             $('#'+domId+'Ul').find('li:eq(0)').find("img").eq(i).attr("src",uri+"/img/x2.png");
        }
    })
    $("#"+domId+"Li").find("img").click(function() {
        var obj = $(this);
        var li = obj.closest("li");
        var star_area_index = li.index();
        var index1 = obj.index();
        li.attr("data-default-index", (parseInt(index1)+1));
        var index = $("#"+domId+"Li").attr("data-default-index");//点击后的索引
        index = parseInt(index);
		$('#'+domId+'Level').html(byIndexLeve(index-1));
        $('#'+domId+'Ul').find('li:eq(0)').find("img").attr("src",uri+"/img/x1.png");
        for (var i=0;i<index;i++){
            $('#'+domId+'Ul').find('li:eq(0)').find("img").eq(i).attr("src",uri+"/img/x2.png");
        }
    });
	}
}
    /*
     * 根据index获取 str
     * **/
    function byIndexLeve(index){
        var str ="";
        switch (index)
        {
            case 0:
                str="一星";
                break;
            case 1:
                str="二星";
                break;
            case 2:
                str="三星";
                break;
            case 3:
                str="四星";
                break;
            case 4:
                str="五星";
                break;
        }
        return str;
    }
