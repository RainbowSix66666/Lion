
$(document).ready(function(){
	$("ul#main_menu li ul a").on("click", function(event){
		var href = $(this).attr("href");
		$("div#main_body").load(href);		
		event.preventDefault();
	});
	$("div#goods a").on("click", function(event){
		var href = $(this).attr("href");
		$("div#main_body").load(href);		
		event.preventDefault();
	});
	//我的订单
	$("div#order a").on("click", function(event){
		var href = $(this).attr("href");
		$("div#main_body").load(href);		
		event.preventDefault();
	});
	//订单管理
	$("ul#demo1 li a").on("click", function(event){
		var href = $(this).attr("href");
		$("div#main_body").load(href);		
		event.preventDefault();
	});
})
