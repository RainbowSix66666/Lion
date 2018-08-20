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
	//取得请求参数，并重新载入Grid数据并刷新
	function getParamAndReloadGrid(){
		var datas={departmentNo:departmentNo,name:employeeName,sex:sex};
		//检查是否输入了生日起始日期
		if(startDate!=null){
			datas.startDate=startDate;
		}
		//检查是否输入了生日截止日期
		if(endDate!=null){
			datas.endDate=endDate;
		}
		//检查是否有角色选中
		if(roles!=null&&roles.length>0){
			datas.roles=roles;
		}
		//清除postData累积的参数
		var postData = $('table#employeeGrid').jqGrid("getGridParam", "postData");
		$.each(postData, function (k, v) {
            delete postData[k];
        }); 
        //设置新的参数
		$("table#employeeGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	}
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
		$("input[type='checkbox'][name='roles']").on("change",function(){
			//先创建保存选中角色编号的数组
			roles=new Array();
			//取得选中的角色
			$("input[type='checkbox'][name='roles']:checked").each(function(index,role){
				//通过$(this) 或 $(role)取得选中的复选框
				roles[index]=$(role).val();
				//roles.push($(role).val());
			});
			getParamAndReloadGrid();
		});
		
	});
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
         mtype: "POST",
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
         },
         ajaxGridOptions:{
        	 cache:false
         }
         
	});
	//增加员工按钮点击事件处理
	$("a#EmployeeAddLink").on("click",function(){
		$("div#EmployeeDialog").load("employee/add.html",function(){
			//取得部门的列表，填充下拉框
			$.getJSON("department/list/all.mvc",function(departmentList){
		        $.each(departmentList,function(index,dm){
					$("select[name='department.no']").append("<option value='"+dm.no+"'>"+dm.name+"</option>");
				});
				
			});
			//取得角色列表生成角色复选框
			$.getJSON("role/list/all/withoutemployees.mvc",function(roleList){
				$.each(roleList,function(index,rm){
					$("div#EmployeeAddRolesCheckBoxArea").append("<label class='checkbox-inline'><input type='checkbox' name='emproles' value='"+rm.no+"'>"+rm.name+"</label>");
				});
			});
			//使用jQuery validate对员工进行数据验证
			$("form#EmployeeAddForm").validate({
				rules:{
					id:{
						required:true,
						mobile:true,
						remote:{
							url:"employee/checkIDCanBeUsed.mvc",
							type:"POST",
							data:{
								employeeId:function(){
									return $("input[name='id']").val();
								}
							}
							
						}
					},
					password:{
						required:true,
						rangelength:[4,10]
					},
					repassword:{
						equalTo:"input[name='password']"
					},
					name:{
						required:true
					},
					age:{
						required:true,
						digits:true,
						range:[18,60]
					},
					salary:{
						required:true,
						number:true,
						min:1800
					},
					birthday:{
						required:true
					},
					joinDate:{
						required:true
					},
					empphoto:{
						accept: "audio/*,image/*"
					}
					
				},
				messages:{
					id:{
						required:"账号为空",
						
						remote:"员工ID已经存在"
					},
					password:{
						required:"密码为空",
						rangelength:"密码长度必须在4到10位长度"
					},
					repassword:{
						equalTo:"密码确认不符"
					},
					name:{
						required:"姓名为空"
					},
					age:{
						required:"年龄为空",
						digits:"年龄必须为整数",
						range:"年龄必须在18到60"
					},
					salary:{
						required:"工资为空",
						number:"工资必须为数值",
						min:"最低工资为1800"
					},
					birthday:{
						required:"生日为空"
					},
					joinDate:{
						required:"加入公司日期为空"
					},
					empphoto:{
						accept: "照片必须为图片或声音"
					}
				}
			});
			
			//拦截员工增加表单提交
			$("form#EmployeeAddForm").ajaxForm(function(result){
				alert(result.message);
				getParamAndReloadGrid(); //重新载入员工列表，并刷新Grid显示。
				$("div#EmployeeDialog").dialog("close"); //关闭弹出Dialog
				
			});
			//定义取消连接点击事件处理
			$("a#EmployeeAddCancelLink").on("click",function(){
				$("div#EmployeeDialog").dialog("close"); //关闭弹出Dialog
			});
			
		});
	    
		//
		$("div#EmployeeDialog").dialog({
			title:"增加新员工",
			width:900,
			height:550
		});
		
		
	});
	
	
	//修改员工按钮点击事件处理
	$("a#EmployeeModifyLink").on("click",function(){
		
		
	});
	//删除员工按钮点击事件处理
	$("a#EmployeeModifyLink").on("click",function(){
		
		
	});
	
	//点击查看员工按钮点击事件处理
	$("a#EmployeeViewLink").on("click",function(){
		if(employeeId==null){
			alert("请选择要查看的员工");
		}
		else{
			$("div#EmployeeDialog").load("employee/view.html",function(){
				
				
			});
		    
			$("div#EmployeeDialog").dialog({
				title:"查看员工信息",
				width:900,
				height:550
			});
		}
	});
	
	
});