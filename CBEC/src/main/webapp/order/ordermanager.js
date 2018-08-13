/**
 * 订单管理的主JS
 */
$(document).ready(function(){
	var orderid=0;//选择的订单ID
	//请求取得订单列表的Rest API
	$.getJSON("order/list/all.mvc",function(orderList){
		var lines="";
		for(var i=0;i<orderList.length;i++){
			lines=lines+"<tr data-no='"+orderList[i].orderid+"'><td>"+orderList[i].orderid+"</td><td>"+orderList[i].comid+"</td><td>"+orderList[i].orderstate+"</td><td>"+orderList[i].bsid+"</td></tr>"
		}
		$("table#orderListTable tbody").html(lines);
		
		//点击TR事件处理
		$("table#orderListTable tbody tr").on("click",function(){
			orderid=$(this).attr("data-no");
			//alert(orderid);
			//选中一行变颜色，表示选中这一行
			$("table#orderListTable tbody tr").css("background-color","#FFFFFF");
			$(this).css("background-color","#EEEE");
		});
	}); 
	
});

//点击增加按钮事件处理
$("a#OrderAddLink").on("click", function(){
	$("div#OrderMainContent").load("order/orderadd.html",function(){
		$("button#orderAddButton").on("click",function(event){
			var comid=$("input[name='comid']").val();
			var orderstate=$("input[name='orderstate']").val();
			var bsid=$("input[name='bsid']").val();
			
			$.post("order/add.mvc",{comid:comid,orderstate:orderstate,bsid:bsid},function(or){
				alert("添加成功");
				if(or == 'OK'){
					alert("添加成功");
					$("div#main_body").load("order/ordermanager.html");
				} else{
					alert("添加失败");
				}
			});
		});
		$("button#orderReturnButton").on("click",function(){
			$("div#OrderMainContent").load("order/ordermanager.html");
		});
	});
	
});

//跳转到修改订单页面
$("a#OrderModifyLink").on("click", function(){
	//alert("修改页面");
	//var orderid=0;
	
	if(orderid==0){
		alert("请选择要修改的订单！");
	} else{
		$("div#OrderMainContent").load("order/ordermodify.html",function(){
			//取得选择订单的信息
			$.getJSON("order/get.mvc",{orderid:orderid},function(resultData){
				$("input[name='comid'").val(resultData.comid);
				$("input[name='orderstate'").val(resultData.orderstate);
				$("input[name='bsid'").val(resultData.bsid);
			});
			//点击修改提交按钮处理
			$("button#orderModifyButton").on("click",function(){
				//取得输入的id值
				var comid = $("input[name='comid']").val();
				var orderstate = $("input[name='orderstate']").val();
				var bsid = $("input[name='bsid']").val();
				
				$.post("order/modify.mvc",{orderid:orderid,comid:comid,orderstate:orderstate,bsid:bsid},function(resultData){
					if(resultData=="ok"){
						alert("订单修改成功");							
					}else{
						alert("订单修改失败");
					}
					//showOrderList();
					});
			});
			$("button#orderModifyCancelButton").on("click",function(){
				showOrderList();
			});		
			
			
		});
	
	}
		
});

//跳转到查看订单页面
$("a#OrderViewLink").on("click", function(){
	if(orderid==0){
		alert("请选择要查看的订单");
	} else{
		$("div#OrderMainContent").load("order/orderview.html",function(){
			//取得选择订单的信息
			$.getJSON("order/get.mvc",{orderid:orderid},function(resultData){
				$("span#orderComid").html(resultData.comid);
				$("span#orderOrderstate").html(resultData.orderstate);
				$("span#orderBsid").html(resultData.bsid);
			});
			//点击返回按钮时间处理
			$("button#orderViewCancelButton").on("click",function(){
				showOrderList();
			});	
		});
	}
	
	
});

//删除订单
$("a#OrderDeleteLink").on("click", function(){
	if(orderid==0){
		alert("请选择要删除的订单");
	} else {
		var confirmResult=confirm("确认要删除选择的订单吗？");
		if(confirmResult){
			$.post("order/delete.mvc",{orderid:orderid},function(resultData){
				if(resultData=="ok"){
					alert("删除订单成功");							
				}else{
					alert("删除订单失败");
				}
				showOrderList();
		});
	}
	}
	
});



