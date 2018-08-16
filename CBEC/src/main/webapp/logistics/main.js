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
			{label:'物流ID',name:'logisticsid',key:true,width:150},
			{label:'地址',name:'address',width:150},
			{label:'快递单号',name:'expressnumber',width:150},
			{label:'收货人',name:'consignee',width:150},
			{label:'手机号',name:'phone',width:150}
			
		],
		width:"100%",
		viewrecords:true,
		height:500,
		rowNum:15,
		pager:"#logisticsGridPager"
		
	});
});

