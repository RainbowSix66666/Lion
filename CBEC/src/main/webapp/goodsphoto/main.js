/**
 * 
 */
/**
 * 员工管理主管理JS
 */
//页面载入成功事件

$(document).ready(function(){
	var photoNo = null;
	var rank=null;
	//取得照片等级列表，填充照片下拉框
	$.getJSON("goodsphoto/list/photorank.mvc",function(photoList){
		$.each(photoList,function(index, photo){
			$("select#photoRank").append("<option value='"+photo.rank+"'>"+photo.rank+"</option>");
		});
	});
	
	
	//取得请求参数，并重新载入Grid数据并刷新
	function getParamGrid(){
		var datas={rank:rank};
		$("table#goodsphotoGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	}
	
	//照片下拉框更改事件处理
	$("select#photoRank").on("change",function(){
		rank=$("select#photoRank").val();
		getParamGrid();
		
	});
	
	//名字更改事件处理
	$("select#goodstitle").on("change",function(){
		rank=$("select#goodstitle").val();
		getParamGrid();
	
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
	
});