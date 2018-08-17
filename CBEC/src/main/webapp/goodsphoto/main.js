/**
 * 
 */
/**
 * 员工管理主管理JS
 */
//页面载入成功事件

$(document).ready(function(){
	var photoNo = null;
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