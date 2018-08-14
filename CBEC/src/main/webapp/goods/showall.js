//商品页面加载成功事件
$(document).ready(function(){
	//alert("成功加载");
	$.getJSON("goods/select/one.mvc",{proid:20},function(one){
		var lines="";
		lines=one.title;
		$("div#title h3").html(lines);
	});
});

//添加响应
$("a#addgoods").on("click", function(){
	$("div#main_body").load("employee/add.html", function(){
		//点击添加用户
		$("button#addgoods").on("click", function(){
			
			var title =$("input[name='title']").val();
			var comid = $("input[name='comid']").val();
			var price = $("input[name = 'price']").val();
			var date = $("input[name = 'date']").val();
			var type = $("input[name = 'type']").val();
			var stock = $("input[name = 'stock']").val();
			var weight = $("input[name = 'weight']").val();
			var desc = $("input[name = 'desc']").val();

			alert(title);
			$.post("goods/add.mvc", {title:title,comid:comid,price:price,date:date,type:type,stock:stock,weight:weight,desc:desc}, function(re){
				
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
$("button#modify").load("employee/modify.html",function(){
	$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
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
				//取得输入的id值
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
