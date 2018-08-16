/**
 * 
 */
/**
 * 员工管理主管理JS
 */
//页面载入成功事件
$(document).ready(function(){
	//显示员工列表表格
	$("table#employeeGrid").jqGrid({
		 url: 'employee/list/condition/page.mvc',
         mtype: "GET",
		 styleUI : 'Bootstrap',
         datatype: "json",
         colModel: [
             { label: '账号', name: 'id', key: true, width: 75 },
             { label: '姓名', name: 'name', width: 150 },
             { label: '性别', name: 'sex', width: 150 },
             { label: '年龄', name: 'age', width: 150 },
             { label:'生日', name: 'birthday', width: 150 },
             { label:'工资', name: 'salary', width: 150 }
         ],
		 viewrecords: true,
         height: 400,
         rowNum: 15,
         pager: "#employeeGridPager"
	});
	
});