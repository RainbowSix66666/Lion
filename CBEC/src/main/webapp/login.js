/**
 * 
 */

$(document).ready(function(){
	$("form#userLogin").validate({
		rules:{
			name:{
				required:true
			},
			password:{
				required:true
			}
		},
		messages:{
			name:"用户名不能为空",
			password:"密码不能为空"
		},
		submitHandler: function(form){
			$(form).ajaxSubmit(function(result){
				if(result.status == "T"){
					window.location.href="index.html";
				}else{
					alert("用户名或密码错误，请重新登录");
				}
			});
			return false;
		}
	});
});