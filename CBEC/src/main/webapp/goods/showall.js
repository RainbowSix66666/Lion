//商品页面加载成功事件
$(document).ready(function(){
	//alert("成功加载");
	var proid=0;
	
			$.getJSON("goods/select/all.mvc",function(all){
				var title="";
				for(var i=0;i<all.length;i++){
					
					title=title + "<div class='col-lg-2'>" + "<div class='panel panel-primary'>" +
	           "<div class='panel-heading' id='title'>" +
	                		"<h3 class='panel-title'><i class='fa fa-shopping-cart'>"+all[i].title+"</i></h3>"+
	            		"</div>"+
	            		"<div>"+
	            		"<a id='goodInfo' href=goodInfo.html?'proid="+all[i].proid+"'><img class='img-thumbnail' src='http://placehold.it/200x200' alt=''/></a>"+
	            		"</div>"+
	        		"</div>"+
	    		"</div>"
					//title=title+"<tr data-no='"+all[i].proid+"'><td>"+all[i].title+"</td></tr>"
	 			}
				$("div#goodsall").html(title);
			});	
});

//添加响应
$("a#addgoods").on("click", function(){
	$("div#main_body").load("goods/add.html", function(){
		//点击添加商品
		$("button#addgoods").on("click", function(){
			alert("进入函数");
			var title =$("input[name='title']").val();
			var comid = $("input[name='comid']").val();
			var price = $("input[name = 'price']").val();
			var state = $("input[name = 'state']").val();
			var date = $("input[name = 'date']").val();
			var type = $("input[name = 'type']").val();
			var stock = $("input[name = 'stock']").val();
			var weight = $("input[name = 'weight']").val();
			var desc = $("input[name = 'desc']").val();

			alert(title);
			$.post("goods/add.mvc", {title:title,comid:comid,price:price,date:date,state:state,type:type,stock:stock,weight:weight,desc:desc}, function(re){
				
				if(re == 'OK'){
					alert("添加成功");
					$("div#main_body").load("goods/showall.html");
				}else{
					alert("添加失败");
				}
			});
		})
	});
})


//修改响应
$("button#modify").on("click",function(){
	$("div#main_body").load("goods/modify.html", function(){
//	alert("点击修改成功");
	$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
		alert("进入函数");
		var title=resultData.title
		alert(title);
				//将原有的值显示
				$("input[name='comid']").val(resultData.comid);
				$("input[name='title']").val(resultData.title);
				$("input[name='price']").val(resultData.price);
				$("input[name='state']").val(resultData.state);
				$("input[name='stock']").val(resultData.stock);
				$("input[name='date']").val(resultData.date);
				$("input[name='type']").val(resultData.type);
				$("input[name='weight']").val(resultData.weight);
				$("input[name='desc']").val(resultData.desc);
			});
	$("button#modifygoods").on("click",function(){
				//取得输入的值
				var title =$("input[name='title']").val();
				var comid = $("input[name='comid']").val();
				var price = $("input[name = 'price']").val();
				var state = $("input[name = 'state']").val();
				var date = $("input[name = 'date']").val();
				var type = $("input[name = 'type']").val();
				var stock = $("input[name = 'stock']").val();
				var weight = $("input[name = 'weight']").val();
				var desc = $("input[name = 'desc']").val();
				
				$.post("goods/modify.mvc",{proid:proid,comid:comid,title:title,price:price,state:state,date:date,type:type,stock:stock,weight:weight,desc:desc});
				
				alert("修改完成");
			});
	});
});

//响应查看详情页
$("a#Info").on("click",function(){
	$("div#goodsall").load("goods/goodInfo.html", function(){
		alert("点击跳转详情成功");
		$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
			alert("进入函数");
			var title=resultData.title
			alert(title);
					//将原有的值显示
					$("input[name='comid']").val(resultData.comid);
					$("input[name='title']").val(resultData.title);
					$("input[name='price']").val(resultData.price);
					$("input[name='state']").val(resultData.state);
					$("input[name='stock']").val(resultData.stock);
					$("input[name='date']").val(resultData.date);
					$("input[name='type']").val(resultData.type);
					$("input[name='weight']").val(resultData.weight);
					$("input[name='desc']").val(resultData.desc);
				});
	});
});
	