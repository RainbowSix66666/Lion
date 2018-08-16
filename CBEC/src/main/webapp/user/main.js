
/*
 * @Author 陈樟永
 * 创建日期：2018-8-10
 * 最新修改日期：2018-8-11
 * */
//显示所有用户数据
	

$(document).ready(function(){
	var userId = "0";
//	alert("run bad");
	//显示所有用户数据
	function showAllUserData(){
		$("div#userContent").load("user/tables.html", function(){
//			alert("hello");
			$('table#userGrid').jqGrid({	
				//获取数据
				 url: 'user/list/condiction/page.mvc',
		         mtype: 'GET',
				 styleUI : 'Bootstrap',
		         datatype: 'json',
		         colModel: [
		        	 { label: '编号', name: 'no',  width: 50 },
		             { label:'用户名', name: 'name', width: 50 },
		             { label:'创建日期', name: 'createDate', width: 50 }
		         ],
		         //设置表格宽高
		         autowidth:true,
		         width: "100%",
				 height: 350,
				 //加载表头
		         pager: "#userGridPager"
		         
			});
			
		});
	}
	
	showAllUserData();	
	
	
	//添加响应
	$("a#toAddUser").on("click", function(){
		$("div#main_content").load("user/addUser.html", function(){
			//点击添加用户
			$("button#addUserButton").on("click", function(){
				var role_type = $("select option").val();
				var name = $("input[name='name']").val();
				var password = $("input[name = 'password']").val();
				alert(role_type);
//				alert(name);
				$.post("user/add.mvc", {name:name, password:password, role:role_type}, function(re){
					
					if(re == 'OK'){
						alert("添加成功");
						$("div#main_content").load("user/main.html");
					}else{
						alert("添加失败");
					}
				});
			})
			//点击返回
			$("button#returnAllUser").on("click", function(){
				$("div#main_content").load("user/main.html");
			});
		});
	});
	//查看响应
	$("a#toshowUser").on("click", function(){
		if(userId == "0"){
			alert("未选择用户");
		}else{
//			alert(userId);
			$("div#main_content").load("user/userInfo.html", function(){
				$.post("user/getbyno.mvc", {no:userId}, function(userData){
					var userName = "<h2><small>用户名: </small>" + userData.name + "</h2>";
					var userRole = "<h2><small>用户角色: </small>" + userData.role + "</h2>";
					var userId = "<h2><small>用户ID: </small>" + userData.no + "</h2>";
					var data = userName + userRole + userId;
					$("div#user-info-panel").html(data);
				})
			});
		}		
	});
	//删除响应
	$("a#todelteUser").on("click", function(){
		if(userId == "0"){
			alert("未选择用户");
		}else{
			if(confirm("是否确定删除用户")){
				$.post("user/delete.mvc", {no:userId},function(result){
					if(result == "OK"){
						alert("删除成功");
					}else{
						alert("删除失败");
					}
				});
			}
			$("div#main_content").load("user/main.html");			
		}	
	})
	//修改响应
	$("a#tomodifyUser").on("click", function(){
		if(userId == "0"){
			alert("未选择用户");
		}else{
//			alert(userId);
			$("div#main_content").load("user/userModify.html", function(){
				$.post("user/getbyno.mvc", {no:userId}, function(userData){
					var userName = userData.name;
					var userPassword = userData.password;
					var userRole = "<option value='" + userData.role + "'>" + userData.role + "</option>";
					$("div#modifyName input").attr("value", userName);
					$("div#modifyPassword input").attr("value", userPassword);
					$("div#modifyRoles select").html(userRole);
				});
				//点击返回
				$("button#returnAllUser").on("click", function(){
					$("div#main_content").load("user/main.html");
				});
				//点击丢该
				$("button#modifyUserButton").on("click", function(){
					var name = $("div#modifyName input").val();
					var role = $("div#modifyRoles select option").val();
					var password = $("div#modifyPassword input").val();
//					alert(role);
					$.post("user/modify.mvc", {no:userId, name:name, role:role, password:password}, function(re){
						alert(re);
					});
				});
			});
			
		}	
	})
})
