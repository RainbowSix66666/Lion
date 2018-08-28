jQuery.ajaxSettings.traditional = true;

$(document).ready(function(){
	
	var userInfo = null
	
	$.getJSON("user/checkLogin.mvc", function(result){
		if(result.status == "F"){
			window.location.href="login.html";
		}else{
			//显示用户名
			$.getJSON("user/getLoginUser.mvc", function(userData){
				userInfo = userData;
//				alert(userInfo.name);
				$("i#userName").html(userInfo.name);
			});
		}	
		
		//退出
		$("a#logout").on("click", function(event){
			
			$.getJSON("user/logout.mvc", function(result){
				if(result.status=="T"){
					window.location.href="login.html";
				}
			});
		});
		
		
		
		//点击菜单
		$("ul#main_menu li ul li a").on("click", function(event){
			alert("click");
//			var href = $(this).attr("href");
//			$("div#main_body").load(href);		
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
	});
});



