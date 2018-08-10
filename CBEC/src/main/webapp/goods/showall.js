//商品页面加载成功事件
$(document).ready(function(){
	alert("成功加载");
	$.getJSON("goods/select/one.mvc",proid=1,function(one){
		var lines="";
		lines=one.title
		$("div#title h3").html(one);
	});
});
