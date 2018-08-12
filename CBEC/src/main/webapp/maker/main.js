$(document).ready(function(){
	
	//请求页面列表
	function showMakerList(){
		
		$("div#makerMainContext").load("maker/list.html",function(){
			$.getJSON("maker/list/all.mvc", function(makerList){
				var lines = "";
				for(var i = 0; i < makerList.length; ++i){			
					lines = lines + "<tr><td>"+makerList[i].makerNO+"</td><td>"
					+ makerList[i].makerName + "</td><td>" + makerList[i].phoneNumber +"</td><td>"
					+ makerList[i].makerPassword + "</td><td>" + makerList[i].address +"</td><td>"
					+ makerList[i].email + "</td></tr>";
				}
				$("table#makerListTable tbody").html(lines);
			});		
			
		});
	}

	//点击增加按钮事件处理
	$("a#makerAdd").on("click",function(){
		$("div#makerMainContext").load("maker/add.html",function(){
			
			$("button#makerAddButton").on("click",function(event){
//				取得输入的id值
				var makerNO = $("input[name='makerNO']").val();
				var makerName = $("input[name='makerName']").val();
				var makerPassword = $("input[name='makerPassword']").val();
				var address = $("input[name='address']").val();
				var email = $("input[name='email']").val();
				var phoneNumber = $("input[name='phoneNumber']").val();
				
				$.post("maker/add.mvc",{makerNO:makerNO,email:email, makerName:makerName, 
					makerPassword:makerPassword, address:address, phoneNumber:phoneNumber},function(resultData){
					alert(resultData);
				});
				showMakerList();
//				event.preventDefault();
			});
			
			
			$("button#makerCancelButton").on("click",function(event){
				alert("nihoa");
				showMakerList();
				event.preventDefault();
			});		
		});
	});

	showMakerList();
	
});






























