/**
 * 
 */
//查看物流

$(document).ready(function(){
	var logisticsid=0;
	
/*$.getJSON("logistics/list/all.mvc",function(logisticsList){
	$.each(logisticsList,function(index,lg){
		//alert(lg);
		$("select#AddressSelection").append ("<option value='"+lg.logisticsid+"'>"+lg.address+"</option>");
	});
	
});



$("select#AddressSelection").on("change",function(){
	logisticsid=$("select#AddressSelection").val();
	alert(logisticsid);
	//getParamAndReloadGrid();
	//var datas={logisticsid:logisticsid,address:address};
	//alert(comid);
	getParamAndReloadGrid();
});	

//取得请求参数，并重新载入Grid数据并刷新
function getParamAndReloadGrid(){
	var datas={logisticsid:logisticsid};
	$("table#logisticsGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
}	
	*/
	
	//显示物流信息列表表格
	$("table#logisticsGrid").jqGrid({
		url:'logistics/list/condition/page.mvc',
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
		rowNum:5,
		rowList:[5,10,15,20],
		pager:"#logisticsGridPager",
		 jsonReader : {
             root: "rows",  //指定数据列表
             page: "page",
             total: "total",
             records: "records",
             repeatitems: true,
             id: "logisticsid"
         },
		multiselect:false,
		onSelectRow:function(id){
			logisticsid=id;
			alert(logisticsid);
		}
	});
});

