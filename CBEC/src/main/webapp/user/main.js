
/*
 * @Author 陈樟永
 * 创建日期：2018-8-10
 * 最新修改日期：2018-8-11
 * */
//显示所有用户数据
function showAllUserData(){
		$("div#userContent").load("user/allUserTable.html", function(){
			$.getJSON("user/all.mvc", function(userList){
				var lines = "";
				for(var i = 0; i < userList.length; ++i){
					lines = lines + "<tr><td>" + userList[i].name + 
					"</td><td>" + userList[i].role + "</td></tr>";
				}
//				alert(lines);
				$("tbody#userListTable").html(lines);
			});
		});
	}

$(document).ready(function(){
//	alert("run bad");
	//显示所有用户数据
	showAllUserData();
	
	$("a#toAddUser").on("click", function(){
		$("div#main_content").load("user/addUser.html", function(){
			$("button#addUserButton").on("click", function(){
				var role_type = "undefine";
				var name = $("input[name='name']").val();
				var password = $("input[name = 'password']").val();
//				alert(role_type);
//				alert(name);
				$.post("user/add.mvc", {name:name, password:password, role:role_type}, function(re){
					if(re == 'OK'){
						alert("放回");
						showAllUserData();
					}else{
						alert("添加失败");
					}
				});
			})
		});
	});
	$("button#returnAllUser").on("click", function(){
		alert("放回");
		showAllUserData();
	});
	
})
