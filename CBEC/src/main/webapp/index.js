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
//				alert(userInfo.no);
				$.getJSON("user/getModuleList.mvc", {userId:userInfo.no}, function(moduleList){
					$.each(moduleList, function(index, module){
						pre = "<li><a href='javascript:;' data-toggle='collapse' data-target=#" +
							module.target + ">";
						mid = "<i class='fa fa-fw fa-shopping-cart'></i>" + 
							module.name + "<i class='fa fa-fw fa-caret-down'></i></a>";
						mid = mid + "<ul id="+ module.target + " class='collapse'>";
//						mid = mid + "<li><a href='xxx.html'>asd</a></li>";
						$.each(module.functions, function(index, fun){							
							mid = mid + "<li><a href=" + fun.url +">"+ fun.name +"</a></li>";							
						});	
						mid = mid + "</ul>";
						suf = "</li>";
						$("ul#main_menu").append(pre + mid + suf);
					});
				});
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
	});
});



