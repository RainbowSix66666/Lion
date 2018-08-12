
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
		$("div#userContent").load("user/allUserTable.html", function(){
			$.getJSON("user/all.mvc", function(userList){
				var lines = "";
				for(var i = 0; i < userList.length; ++i){
					lines = lines + "<tr user-id='"+ userList[i].no + "'><td>" + userList[i].name + 
					"</td><td>" + userList[i].role + "</td></tr>";
				}
//				alert(lines);
				$("table#userListTable tbody").html(lines);
				//点击tr时间处理
//				alert("va");
				$("table#userListTable tbody tr").on("click",function(){				
//					alert($(this).attr("user-id"));
					userId = $(this).attr("user-id");
					$("table#userListTable tbody tr").css("background-color","#FFFFFF")
					$(this).css("background-color","#EEEE");
				});
			});
		});
	}
	
	showAllUserData();
	//添加响应
	$("a#toAddUser").on("click", function(){
		$("div#main_content").load("user/addUser.html", function(){
			//点击添加用户
			$("button#addUserButton").on("click", function(){
				var role_type = "undefine";
				var name = $("input[name='name']").val();
				var password = $("input[name = 'password']").val();
//				alert(role_type);
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
			alert(userId);
		}		
	});
	//删除响应
	$("a#todelteUser").on("click", function(){
		
	})
	$("a#todelteUser").on("click", function(){
		
	})
})
