/**
 * 
 */
//查看物流

$(document).ready(function(){
	var logisticsid=0;
	var consignee=null;
	var address=null;
	
	//取得请求参数，并重新载入Grid数据并刷新
	function getParamAndReloadGrid(){
		var datas={address:address,consignee:consignee};
		
		var postData = $("table#logisticsGrid").jqGrid("getGridParam",{postData:datas});
		//清楚postData累积的参数
		/*$.each(postData, function (k,v){
			delete postData[k];
		});*/
		//设置新的参数
		$("table#logisticsGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	}
	
	//取得地址列表，填充地址下拉框
	$.getJSON("logistics/list/address.mvc",function(logisticsList){
		$.each(logisticsList,function(index,lg){
			$("select#AddressSelection").append ("<option value='"+lg.address+"'>"+lg.address+"</option>");
		});
	});
	
	//地址下拉框更改事件处理
	$("select#AddressSelection").on("change",function(){
		address=$("select#AddressSelection").val();
		getParamAndReloadGrid();
	});	

	//收货人的更改事件
	$("input#consignee").on("change",function(){
		consignee=$("input#consignee").val();
		getParamAndReloadGrid();
	});
	
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
			//alert(logisticsid);
		},		
	});
	
	//增加物流按钮点击事件处理
	$("a#LogisticsAddLink").on("click",function(){
		$("div#LogisticsDialog").load("logistics/LogisticsAdd.html",function(){
			//取得地址列表，填充地址下拉框
			$.getJSON("logistics/list/address.mvc",function(logisticsList){
				$.each(logisticsList,function(index,lg){
					$("select#AddressSelection").append ("<option value='"+lg.address+"'>"+lg.address+"</option>");
				});
			});
			//点击增加按钮事件处理
			$("button#LogisticsAddButton").on("click",function(){
				
				$("div#LogisticsDialog").dialog("close"); //关闭弹出Dialog
			});
			
			//使用JQuery validate对员工进行数据验证
			$("form#logisticsAddForm").validate({
				rules:{
					 address:{
						 required:true,
					 },
					 expressnumber:{
						 required:true,
						 rangelength:[6,10],
						 digits:true
					 },
					 consignee:{
						 required:true,
					 },
					 phone:{
						 required:true,
						 rangelength:[11,11],
						 digits:true
					 }
				},
			
				messages:{
					address:{
						required:"地址不能为空"
					},
					expressnumber:{
						required:"快递单号不能为空",
						rangelength:"长度必须为6-10位数字",
						digits:"必须为整数"
					},
					 consignee:{
						 required:"收货人不能为空"
					 },
					 phone:{
						 required:"手机号不能为空",
						 rangelength:"长度为11位",
						 digits:"必须为整数"
					 }
				}
			});
			
			//拦截物流增加表单提交
			$("form#logisticsAddForm").ajaxForm(function(result){
				//alert(result.message);
				//alert(JSON.stringify(result));
				getParamAndReloadGrid(); //重新载入物流列表，并刷新Grid显示。
				alert("添加物流信息成功")
				$("div#LogisticsDialog").dialog("close"); //关闭弹出Dialog
			});
			//定义取消连接点击事件处理
			$("button#LogisticsReturnButton").on("click",function(){
				$("div#LogisticsDialog").dialog("close"); //关闭弹出Dialog
			});
			$("div#LogisticsDialog").dialog({
				title:"增加新物流",
				width:900,
				height:550
			});
			
		});
	});
	
	//修改物流按钮点击事件处理
	$("a#LogisticsModifyLink").on("click",function(){
		$("div#LogisticsDialog").load("logistics/LogisticsModify.html",function(){
			//定义提交按钮点击事件处理
			$("button#logisticsModifyButton").on("click",function(){
				
				$("div#LogisticsDialog").dialog("close"); //关闭弹出Dialog
			});
			
			/*//拦截物流增加表单提交
			$("form#orderAddForm").ajaxForm(function(result){
				alert(result.message);
				getParamAndReloadGrid(); //重新载入物流列表，并刷新Grid显示。
				$("div#LogisticsDialog").dialog("close"); //关闭弹出Dialog
			});*/
			//定义取消连接点击事件处理
			$("button#logisticsModifyCancelButton").on("click",function(){
				$("div#LogisticsDialog").dialog("close"); //关闭弹出Dialog
			});
			$("div#LogisticsDialog").dialog({
				title:"修改物流",
				width:900,
				height:550
			});
			
		});
	});
	
	//查看物流按钮点击事件处理
	$("a#LogisticsViewLink").on("click",function(){
		$("div#LogisticsDialog").load("logistics/LogisticsView.html",function(){
			
			
			//定义取消连接点击事件处理
			$("button#LogisticsViewCancelButton").on("click",function(){
				$("div#LogisticsDialog").dialog("close"); //关闭弹出Dialog
			});
			$("div#LogisticsDialog").dialog({
				title:"修改物流",
				width:900,
				height:550
			});
			
		});
	});
	
});