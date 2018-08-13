$(document).ready(function(){
	var makerId = 0;
	//请求页面列表
	function showMakerList(){
		
		$("div#makerMainContext").load("maker/list.html",function(){
			$.getJSON("maker/list/all.mvc", function(makerList){
				var lines = "";
				for(var i = 0; i < makerList.length; ++i){			
					lines = lines + "<tr data-no='"+makerList[i].makerId+"'><td>"+makerList[i].makerNO+"</td><td>"
					+ makerList[i].makerName + "</td><td>" + makerList[i].phoneNumber +"</td><td>"
					+ makerList[i].makerPassword + "</td><td>" + makerList[i].address +"</td><td>"
					+ makerList[i].email + "</td></tr>";
				}
				$("table#makerListTable tbody").html(lines);
				//事件点击处理
				$("table#makerListTable tbody tr").on("click", function(){
					makerId=$(this).attr("data-no");
					$("table#makerListTable tbody tr").css("background-color", "#FFFFFF");
					$(this).css("background-color", "#EEEE");
										
				});
			});		
			
		});
		makerId = 0;
	}

	//点击增加按钮事件处理
	$("a#makerAdd").on("click",function(){
		$("div#makerMainContext").load("maker/add.html",function(){
			
			$("button#makerAddButton").on("click",function(event){
				//取得输入的id值
				var makerNO = $("input[name='makerNO']").val();
				var makerName = $("input[name='makerName']").val();
				var makerPassword = $("input[name='makerPassword']").val();
				var address = $("input[name='address']").val();
				var email = $("input[name='email']").val();
				var phoneNumber = $("input[name='phoneNumber']").val();
				
				$.post("maker/add.mvc",{makerNO:makerNO,email:email, makerName:makerName, 
					makerPassword:makerPassword, address:address, phoneNumber:phoneNumber},function(resultData){
					alert("添加成功");
					showMakerList();
					});
			});
			
			
			$("button#makerCancelButton").on("click",function(event){
				showMakerList();
			});		
		});
	});

	
	//	添加修改按钮
	$("a#makerModify").on("click",function(){
		if(makerId==0){
			alert("请先选中一个品牌商！");
		}else{
			$("div#makerMainContext").load("maker/modify.html",function(){
				//取得选择的部门的信息
				$.getJSON("maker/bymakerId.mvc",{makerId:makerId},function(resultData){
					/*$("span#makerId").html(resultData.makerId);*/
					$("input[name='makerNO'").val(resultData.makerNO);
					$("input[name='makerName'").val(resultData.makerName);
					$("input[name='makerPassword'").val(resultData.makerPassword);
					$("input[name='address'").val(resultData.address);
					$("input[name='email'").val(resultData.email);
					$("input[name='phoneNumber'").val(resultData.phoneNumber);
				});
				//点击修改提交按钮处理
				$("button#makerModifyButton").on("click",function(){
					//取得输入的id值
					var makerNO = $("input[name='makerNO']").val();
					var makerName = $("input[name='makerName']").val();
					var makerPassword = $("input[name='makerPassword']").val();
					var address = $("input[name='address']").val();
					var email = $("input[name='email']").val();
					var phoneNumber = $("input[name='phoneNumber']").val();
					$.post("maker/modify.mvc",{makerId:makerId,makerNO:makerNO,email:email, makerName:makerName, 
						makerPassword:makerPassword, address:address, phoneNumber:phoneNumber},function(resultData){
						if(resultData=="ok"){
							alert("品牌商信息修改成功");							
						}else{
							alert("品牌商信息修改失败");
						}
						showMakerList();
						});
				});
				$("button#makerModifyCancelButton").on("click",function(){
					showMakerList();
				});		
				
				
					
			});			
		}
	});
	
	//添加删除按钮
	$("a#makerDelete").on("click",function(){
		if(makerId==0){
			alert("请先选中一个要删除的品牌商！");
		}else{
			var confirmResult = confirm("确认要删除选择的品牌商？");
			if(confirmResult){
				$.post("maker/delete.mvc", {makerId:makerId}, function(resultData){
					if(resultData=="ok"){
						alert("品牌商信息删除成功");							
					}else{
						alert("品牌商信息删除失败");
					}
					showMakerList();
				});
			}
		}
	});
	
	
//	添加查看按钮
	$("a#makerView").on("click",function(){
		if(makerId==0){
			alert("请先选中一个品牌商！");
		}else{
			$("div#makerMainContext").load("maker/view.html",function(){
				//取得选择的部门的信息
				$.getJSON("maker/bymakerId.mvc",{makerId:makerId},function(resultData){
					$("span#makerId").html(resultData.makerId);
					$("span#makerNO").html(resultData.makerNO);
					$("span#makerName").html(resultData.makerName);
					$("span#makerPassword").html(resultData.makerPassword);
					$("span#address").html(resultData.address);
					$("span#email").html(resultData.email);
					$("span#phoneNumber").html(resultData.phoneNumber);
				});
				
				//查看页面的返回按钮
				$("button#makerViewCancelButton").on("click",function(){
					showMakerList();
				});	
			});
		}
	});
	
	showMakerList();
	
});






























