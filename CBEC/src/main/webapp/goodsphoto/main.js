/**
 * 
 */
/**
 * 照片管理JS
 */
//页面载入成功事件

$(document).ready(function(){
	var photoNo = null;
	var rank=null;
	var photoName=null;
	var photoGoodsId=null;
	var matchPhotoId=null;
	var startDate=null;
	var endDate=null;
	//取得照片等级列表，填充照片下拉框
	$.getJSON("goodsphoto/list/photorank.mvc",function(photoList){
		$.each(photoList,function(index, photo){
			$("select#photoRank").append("<option value='"+photo.rank+"'>"+photo.rank+"</option>");
		});
	});
	
	
	//取得请求参数，并重新载入Grid数据并刷新
	function getParamGrid(){
		var datas={rank:rank, proid:photoGoodsId, photoId:matchPhotoId};
		
		//检查是否输入了照片上传起始日期
		if(startDate!=null){
			datas.startDate=startDate;
		}
		//检查是否输入了照片上传截止日期
		if(endDate!=null){
			datas.endDate=endDate;
		}
		 
		//清除postData累积的参数
		var postData = $('table#goodsphotoGrid').jqGrid("getGridParam", "postData");
		$.each(postData, function (k, v) {
            delete postData[k];
        });
        //设置新的参数
		$("table#goodsphotoGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	}
	
	//照片等级下拉框更改事件处理
	$("select#photoRank").on("change",function(){
		rank=$("select#photoRank").val();
		getParamGrid();
		
	});
	
	//名字更改事件处理
	$("input#photoName").on("change",function(){
		photoName=$("input#photoName").val();
		getParamGrid();
	
	});
	
	//商品id更改事件处理
	$("input#photoGoodsId").on("change",function(){
		photoGoodsId=$("input#photoGoodsId").val();
		getParamGrid();
		
	});
	
	//照片id更改事件处理
	$("input#matchPhotoId").on("change",function(){
		matchPhotoId=$("input#matchPhotoId").val();
		alert(matchPhotoId);
		getParamGrid();
		
	});
	
	//起始日期更改事件处理
	$("input#photoStartDate").on("change",function(){
		startDate=$("input#photoStartDate").val();
		getParamAndReloadGrid();
	});
	
	//结束日期更改事件处理
	$("input#photoEndDate").on("change",function(){
		endDate=$("input#photoEndDate").val();
		getParamAndReloadGrid();
	});
	
	/*显示员工列表表格*/
	$("table#goodsphotoGrid").jqGrid({
		 url: 'goodsphoto/list/byphotoid/allwithoutgoods/page.mvc',
         mtype: "GET",
		 styleUI : 'Bootstrap',
         datatype: "json",
         colModel: [
             { label: '照片id', name: 'photoId', key: true, width: 75 },
             { label: '商品id', name: 'good.proid', width: 150 },
             { label: '照片说明', name: 'des', width: 150 },
             { label: '商品名称', name: 'good.title', width: 150 },
             { label:'照片等级', name: 'rank', width: 150 },
         ],
         autowidth:true,
		 viewrecords: true,
		 width: "100%",
         height: 400,
         rowNum: 3,
         rowList: [1,2,3,5,10,15],
         pager: "#goodsphotoGridPager",
		jsonReader : {
		     root: "rows",  //指定数据列表
		     page: "page",
		     total: "total",
		     records: "records",
		     repeatitems: true,
		     id: "photoId",
			},
			multiselect:false,
			onSelectRow:function(photoId){
				photoNo = photoId;
				alert(photoNo);
			}

	});
	
	
	//增加员工按钮点击事件处理
	$("a#GoodsPhotoAddLink").on("click",function(){
		
		$("div#GoodsPhotoDialog").load("goodsphoto/add.html",function(){
			//取得照片等级列表，填充照片下拉框
			$.getJSON("goodsphoto/list/photorank.mvc",function(photoList){
				$.each(photoList,function(index, photo){
					$("select#addRank").append("<option value='"+photo.rank+"'>"+photo.rank+"</option>");
				});
			});	
		});	
		//加载弹窗
		$("div#GoodsPhotoDialog").dialog({
			title:"增加新员工",
			width:900,
			height:550
		});
		
	});
	
	
});