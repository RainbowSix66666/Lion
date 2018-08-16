/**
 * 
 */
/**
 * 员工管理主管理JS
 */
//页面载入成功事件

$(document).ready(function(){
	alert("1");
	var photoNo = null;
	/*显示员工列表表格*/
	$("table#goodsphotoGrid").jqGrid({
		 url: 'goodsphoto/list/byphotoid/allwithoutgoods/page.mvc',
         mtype: "GET",
		 styleUI : 'Bootstrap',
         datatype: "json",
         colModel: [
             { label: '账号', name: 'photoId', key: true, width: 75 },
             { label: '姓名', name: 'proid', width: 150 },
             { label: '性别', name: 'des', width: 150 },
             { label: '年龄', name: 'age', width: 150 },
             { label:'生日', name: 'rank', width: 150 },
         ],
         autowidth:true,
		 viewrecords: true,
		 width: "100%",
         height: 400,
         rowNum: 3,
         rowList: [1,2,3],
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