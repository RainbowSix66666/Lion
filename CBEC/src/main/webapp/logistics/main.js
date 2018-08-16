/**
 * 
 */
//查看物流

$(document).ready(function(){
	//显示物流信息列表表格
	$("table#logisticsGrid").jqGrid({
		url:'logistics/list/all.mvc',
		mtype:'GET',
		styleUI:'Bootstrap',
		datatype:'json',
		colModel:[
			{lable:'物流ID',name:'logisticsid',key:true,width:75},
			{lable:'地址',name:'address',width:150},
			{lable:'快递单号',name:'expressnumber',width:150},
			{lable:'收货人',name:'consignee',width:150},
			{lable:'手机号',name:'phone',width:150}
			
		],
		viewrecords:true,
		height:600,
		rowNum:15,
		pager:"#logisticsGridPager"
		
	});
});

