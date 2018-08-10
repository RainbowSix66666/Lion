/*$(document).ready(function(){
		//页面操作代码区
		$("ul#demo1 li a").on("click",function(event){
			var href = $(this).attr("href");
			alert(href);
			$("div#main_body").load(href);
			event.preventDefault();
		});
	//请求取得部门列表的REST API
	$.getJSON("maker/list/all.mvc", function(makerList){
		alert("gjg");
	});
	alert("ok");
	alert("nihao");
});
*/

$(document).ready(function(){
	$.getJSON("maker/list/all.mvc", function(makerList){
		var lines = "";
		for(var i = 0; i < makerList.length; ++i){			
			lines = lines + "<tr><td>"+makerList[i].makerId+"</td><td>"
			+ makerList[i].makerName + "</td><td>" + makerList[i].phoneNumber +"</td><td>"
			+ makerList[i].makerPassword + "</td><td>" + makerList[i].address +"</td><td>"
			+ makerList[i].email + "</td></tr>";
		}
		$("table#makerListTable tbody").html(lines);
	});
//	$.ge
})
