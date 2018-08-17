/**
 * 员工管理主管理JS
 */
//页面载入成功事件
$(document).ready(function(){
	var employeeId=null;
	var departmentNo=0; //部门的编号
	var employeeName="";
	var startDate=null;
	var endDate=null;
	var sex=null;
	var roles=null; //选中的角色
	//取得部门列表，填充部门下拉框
	$.getJSON("department/list/all.mvc",function(departmentList){
        
		$.each(departmentList,function(index,dm){
			$("select#DepartmentSelection").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
		});
		
	});
	
	
	//取得角色的列表，生成复选框
	$.getJSON("role/list/all/withoutemployees.mvc",function(roleList){
		$.each(roleList,function(index,rm){
			$("div#RolesCheckboxArea").append("<label class='checkbox-inline'><input type='checkbox' name='roles' value='"+rm.no+"'>"+rm.name+"</label>");
		});
		//角色复选框点击事件处理
		$("input[type='checkbox'][name='roles']").on("click",function(){
			//先创建保存选中角色编号的数组
			roles=new Array();
			//取得选中的角色
			alert(roles);
			$("input[type='checkbox'][name='roles']:checked").each(function(index,role){
				//通过$(this) 或 $(role)取得选中的复选框
				//roles[index]=$(role).val();
				alert($(role).val());
				roles.push($(role).val());
			});
			getParamAndReloadGrid();
			
		});
		
	});
	//取得请求参数，并重新载入Grid数据并刷新
	function getParamAndReloadGrid(){
		var datas={departmentNo:departmentNo,name:employeeName,sex:sex};
		if(startDate!=null){
			datas.startDate=startDate;
			
		}
		if(endDate!=null){
			datas.endDate=endDate;
		}
		if(roles!=null){
			datas.roles=roles;
		}
		$("table#employeeGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	}
	//部门下拉框更改事件处理
	$("select#DepartmentSelection").on("change",function(){
		departmentNo=$("select#DepartmentSelection").val();
		
		getParamAndReloadGrid();
		
		
	});
	//姓名的更改事件
	$("input#employeeName").on("change",function(){
		employeeName=$("input#employeeName").val();
		getParamAndReloadGrid();
		
	});
	//性别的选择更改事件处理
	$("input[type='radio'][name='empsex']").on("change",function(){
		sex=$(this).val();
		//sex=$("input[type='radio'][name='empsex']:checked").val();
		getParamAndReloadGrid();
		
	});
	//起始日期更改事件处理
	$("input#StartBirthdayDate").on("change",function(){
		startDate=$("input#StartBirthdayDate").val();
		getParamAndReloadGrid();
	});
	//截止日期更改事件处理
	$("input#EndBirthdayDate").on("change",function(){
		endDate=$("input#EndBirthdayDate").val();
		getParamAndReloadGrid();
	});

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
	//增加员工按钮点击事件处理
	$("a#EmployeeAddLink").on("click",function(){
		
		
	});
	
	//增加员工按钮点击事件处理
	$("a#EmployeeModifyLink").on("click",function(){
		
		
	});
	
	
});