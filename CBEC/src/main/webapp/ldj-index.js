/**
 * 
 */
jQuery.ajaxSettings.traditional = true;
$(document).ready(function(){
	var orderInfo=null;
	
	$.getJSON("order/checkLogin.mvc",function(checkResult){
		if(checkResult.status=="N"){
			location.href="ldj-login.html";
		}
		else{
			$.getJSON("order/getLoginOrder.mvc",function(orderData){
				orderInfo=orderData;
				$("span#loginOrderName").html(orderInfo.orderid);
			});
			$("a#OrderLogoutLink").on("click",function(){
				$.getJSON("order/logout.mvc",function(){
					location.href="ldj-login.html";
				});
			});
			
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
		}
	});
});