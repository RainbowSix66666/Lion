/**
 * 订单管理的主JS
 */
$(document).ready(function(){
	//请求取得订单列表的Rest API
	$.getJSON("order/list/all.mvc",function(orderList){
		var lines="";
		for(var i=0;i<orderList.length;i++){
			lines=lines+"<tr><td>"+orderList[i].orderid+"</td><td>"+orderList[i].comid+"</td><td>"+orderList[i].orderstate+"</td><td>"+orderList[i].bsid+"</td></tr>"
		}
		$("table#orderListTable tbody").html(lines);
	}); 
});

//跳转到增加订单页面
$("a#OrderAddLink").on("click", function(event){
	var href = $(this).attr("href");
	$("div#main_body").load(href);		
	event.preventDefault();
});

//跳转到修改订单页面
$("a#OrderModifyLink").on("click", function(event){
	var href = $(this).attr("href");
	$("div#main_body").load(href);		
	event.preventDefault();
});

//跳转到查看订单页面
$("a#OrderSelectLink").on("click", function(event){
	var href = $(this).attr("href");
	$("div#main_body").load(href);		
	event.preventDefault();
});

//删除订单
$("a#OrderDeleteLink").on("click", function(event){
	alert("删除成功");
});