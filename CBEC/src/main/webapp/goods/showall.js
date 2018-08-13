//商品页面加载成功事件
$(document).ready(function(){
	//alert("成功加载");
	$.getJSON("goods/select/one.mvc",{proid:2},function(one){
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
			alert("cao");
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