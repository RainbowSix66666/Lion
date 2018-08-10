
/*
 * @Author 陈樟永
 * 创建日期：2018-8-10
 * 最新修改日期：2018-8-10
 * */

$(document).ready(function(){
//	alert("run bad");
	$.getJSON("user/all.mvc", function(userList){
//		alert(userList);
		var lines = "";
		for(var i = 0; i < userList.length; ++i){
			lines = lines + "<tr><td>" + userList[i].name + 
			"</td><td>" + userList[i].role + "</td></tr>";
		}
//		alert(lines);
		$("table#userListTable tbody").html(lines);
	});
//	$.ge
})
//<tr><td>/blog/post.html</td><td>1233</td><td>93.2%</td><td>$126.34</td></tr>
