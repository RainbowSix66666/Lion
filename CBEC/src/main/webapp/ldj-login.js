/**
 * 练习登录界面
 */
$(document).ready(function(){
	$("form#OrderLoginForm").validate({
		rules:{
			orderid:{
				required:true
			},
			comid:{
				required:true
			}
		},
		messages:{
			orderid:{
				required:"账号为空"
			},
			comid:{
				required:"密码为空"
			}
		}
	});
	
	$("form#OrderLoginForm").ajaxForm(function(loginResult){
		if(loginResult.status=="Y"){
			window.location.href="ldj-index.html";
		}
		else{
			BootstrapDialog.show({
				title:"逆天订单登录提示",
				message:"<h4>"+loginResult.message+"</h4>",
				buttons: [{
	                label: '关闭',
	                action: function(dialog) {
	                    	dialog.close();
	                	}
	            	}
				]
			});
		}
	});
	
});