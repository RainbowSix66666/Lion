/**
 * 员工管理主管理JS
 */
//页面载入成功事件
$(document).ready(function(){
	var employeeId=null;
	
	//显示员工列表表格
	$("table#employeeGrid").jqGrid({
		 url: 'employee/list/condition/page.mvc',
         mtype: "GET",
		 styleUI : 'Bootstrap',
         datatype: "json",
         colModel: [
        	 { label: '部门', name: 'department.name',  width: 100 },
        	 { label: '部门位置', name: 'department.location.name', width: 100 },
        	 { label: '账号', name: 'id', key: true, width: 75 },
             { label: '姓名', name: 'name', width: 100 },
             { label: '性别', name: 'sex', width: 50 },
             { label: '年龄', name: 'age', width: 50 },
             { label:'生日', name: 'birthday', width: 100 },
             { label:'工资', name: 'salary', width: 50 }
         ],
         autowidth:true,
		 viewrecords: true,
         width: "100%",
		 height: 350,
         rowNum: 10,
         rowList:[2,10,15,20],
         pager: "#employeeGridPager",
         jsonReader : {
             root: "rows",  //指定数据列表
             page: "page",
             total: "total",
             records: "records",
             repeatitems: true,
             id: "id"
         },
         multiselect:false,
         onSelectRow:function(id){
        	 employeeId=id;
        	 alert(employeeId);
         }
         
         
	
	});
	
});