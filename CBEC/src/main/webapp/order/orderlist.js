/**
 * 我的订单主js
 */

$(document).ready(function(){
	//请求取得订单列表的Rest API
	$.getJSON("order/list/all.mvc",function(orderList){
		var lines="";
		for(var i=0;i<orderList.length;i++){
			lines=lines+"<tr><td>"+orderList[i].orderid+"</td><td>"+orderList[i].comid+"</td><td>"+orderList[i].orderstate+"</td><td>"+orderList[i].bsid+"</td><td>"+orderList[i].logisticsid+"</td></tr>"
		}
		$("table#orderListTable tbody").html(lines);
	}); 
});
