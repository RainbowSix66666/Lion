
/*
 * @Author 陈樟永
 * 创建日期：2018-8-10
 * 最新修改日期：2018-8-11
 * */
function writeObj(obj){ 
 var description = ""; 
 for(var i in obj){ 
 var property=obj[i]; 
 description+=i+" = "+property+"\n"; 
 } 
 alert(description); 
}

$(document).ready(function(){
	var userId = "0";
	var userName = null;
	var before = null;
	var after = null;
	var groballRoles = null;
	var allRoles = new Array();
	var flage = false;
	var areaId = "0";
//	alert("run bad");
	
	function getParamAndReloadGrid(){		
		
		var datas={name:userName, area:areaId};
		
		if(before != null){
//			alert(before);
			datas.before = before;
		}
		if(after != null){
			datas.after = after;
		}
		if(groballRoles != null){
			datas.roles = groballRoles;
		}
		//清除累积的参数
		var postData = $('table#userGrid').jqGrid("getGridParam", "postData");
		$.each(postData, function (k, v) {
            delete postData[k];
        });
		
		$("table#userGrid").jqGrid("setGridParam",{postData:datas}).trigger("reloadGrid");
	}
	
	//显示所有用户数据
	function showAllUserData(){
//		alert("load html");
		$("div#userContent").load("user/tables.html", function(){
			$('table#userGrid').jqGrid({	
				//获取数据
				url: 'user/list/condiction/page.mvc',
		        mtype: 'GET',
				styleUI : 'Bootstrap',
		        datatype: 'json',
		        colModel: [
		        	 { label: '编号', name: 'no',  width: 50 },
		        	 { label:'用户名', name: 'name', width: 50 },
		        	 { label:'所在地区', name: 'area.desc', width: 50 },
		        	 { label:'创建日期', name: 'createDate', width: 50 }
		        ],
		         //设置表格宽高
		        autowidth:true,
		        width: "100%",
				height: 350,
				 //加载表头
		        pager: "#userGridPager",
		         //设置每页格式
		        rowNum: 10,
		        rowList:[2,10,15,20],
		        //映射
		        jsonReader : {
		             rows: "rows",  //指定数据列表
		             page: "page",
		             total: "total",
		             records: "records",
		             repeatitems: true,
		             id: "no"
		         },
		         //选择单条数据
		         multiselect:false,
		         onSelectRow:function(id){
		        	 userId = id;
//		        	 alert(id);
		         }
			});
			
			//选择角色
			$.getJSON("role/all.mvc",function(roleList){
				$.each(roleList,function(index,rm){
					$("div#rolesSelect").append("<label class='checkbox-inline'><input type='checkbox' name='roles' value='"+rm.id+"'>"+rm.detial+"</label>");
					allRoles.push(rm.id);
				});
//				alert(allRoles);
				$("input[type='checkbox'][name='roles']").on("click",function(){
					//先创建保存选中角色编号的数组
					var roles=new Array();
					//取得选中的角色
					flage = false;
					$("input[type='checkbox'][name='roles']:checked").each(function(index,role){
						//通过$(this) 或 $(role)取得选中的复选框
						roles.push($(role).val());
						flage = true;
					});
					groballRoles = roles;
					
					getParamAndReloadGrid();
				});
				
			});
			
			
			
			//生成下拉框
			$.getJSON("area/list/all.mvc", function(areaList){
				$.each(areaList.rows,function(index,elemt){
//					alert(elemt.id);
//					alert(elemt.desc);
					$("select#selectTest").append("<option value='"+elemt.id+"'>"+elemt.desc+"</option>");
				});
				//下拉框监听
				$("select#selectTest").on("change", function(){					
					areaId = $(this).val();
//					alert(areaId);	
					getParamAndReloadGrid();
				});
			});
			
			
			//用户名响应
			$("input#userName").on("change", function(){
				userName = $(this).val();
//				alert(userName);
				getParamAndReloadGrid();
			});
			
			//单选监听
			$("input[type='radio'][name='radioTest']").on("change",function(){
				alert($(this).val());				
			});
			//起始日期更改事件处理
			$("input#beforeCreateDate").on("change",function(){
				before = $("input#beforeCreateDate").val();
				getParamAndReloadGrid();
			});
			//终止日期更改事件处理
			$("input#afterCreateDate").on("change",function(){
				after = $("input#afterCreateDate").val();
				getParamAndReloadGrid();
			});
			
			
		});
		
	}
	
	
	showAllUserData();
	$("input#userName").on("change", function(){
		alert("dasd");
	});
	//添加响应
	$("a#toAddUser").on("click", function(){
//		alert("click add");
		
		$("div#userDialog").dialog({
			title:"增加新用户",
			width:450,
			height:450
		});
		
		$("div#userDialog").load("user/addUser.html", function(){
			$.getJSON("area/list/all.mvc", function(areaList){
				$.each(areaList.rows,function(index,elemt){
					$("select#areaSelection").append("<option value='"+elemt.id+"'>"+elemt.desc+"</option>");
				});
			});
			$.getJSON("role/all.mvc",function(roleList){
				$.each(roleList,function(index,rm){
					$("div#addRolesSelect").append("<label class='checkbox-inline'><input type='checkbox' name='roles' value='"+rm.id+"'>"+rm.detial+"</label>");
					allRoles.push(rm.id);
				});
			});
			
			//表单验证
			$("form#addUser").validate({
				//表单提交处理
				submitHandler: function(form) {
					$(form).ajaxSubmit(function() {   
					      alert("添加成功");				      
					      showAllUserData();
					      $("div#userDialog").dialog("close");
//					      alert($("input[name='password_agin']").val());
					 });		
					//阻止表单提交跳转
					 return false; 
				  },
				
				rules:{
					name:{
						required:true,
						minlength:4,
						remote:{
							url:"user/checkNameUsed.mvc",
							type:"get",
							data:{
								name:function(){
//									alert($("input[name='name']").val());
									return $("input[name='name']").val();
								}
							}
						}
					},
				    password:{
				    	required:true,
				    	minlength:6
				    },
					password_agin:{
						equalTo:"input[name='password']"
					},
					userHead:{
						accept: "image/*"
					}
				},
				messages:{
					name:{
						required:"用户名不能为空",
						minlength:"用户名不能短于4个字符",
						remote:"用户名已存在"
					},
					password:{
						required:"密码不能为空",
						minlength:"密码不能短于6个字符"
					},
					password_agin:{
						equalTo:"两次密码不一致"
					},
					userHead:{
						accept:"上传文件必须为图片"
					}
				}
			});
			
			/*$("form#addUser").submit(function(){
				 $(this).ajaxSubmit(function() {   
				      alert("添加成功");				      
				      showAllUserData();
				      $("div#userDialog").dialog("close");
				 });				
				 return false; //阻止表单默认提交	
			});*/
			
			
			
			$("button#returnAllUser").on("click", function(){
//				alert("click");
				$("div#userDialog").dialog("close");
			});
		});
		
	});
	//查看响应
	$("a#toshowUser").on("click", function(){
		if(userId == "0"){
			alert("未选择用户");
		}else{
//			alert(userId);
			$("div#userContent").load("user/userInfo.html", function(){
				$.post("user/getbyno.mvc", {no:userId}, function(userData){
					var userName = "<h2><small>用户名: </small>" + userData.name + "</h2>";
					var userRole = "<h2><small>用户角色: </small>" + userData.role + "</h2>";
					var userId = "<h2><small>用户ID: </small>" + userData.no + "</h2>";
					var data = userName + userRole + userId;
					$("div#user-info-panel").html(data);
				})
			});
		}		
	});
	//删除响应
	$("a#todelteUser").on("click", function(){
		if(userId == "0"){
			alert("未选择用户");
		}else{
			if(confirm("是否确定删除用户")){
				$.post("user/delete.mvc", {no:userId},function(result){
					if(result == "OK"){
						alert("删除成功");
					}else{
						alert("删除失败");
					}
				});
			}
			showAllUserData();		
		}	
	});
	//修改响应
	$("a#tomodifyUser").on("click", function(){
		if(userId == "0"){
			alert("未选择用户");
		}else{
//			alert(userId);
			$("div#userContent").load("user/userModify.html", function(){
				$.post("user/getbyno.mvc", {no:userId}, function(userData){
					var userName = userData.name;
					var userPassword = userData.password;
					var userRole = "<option value='" + userData.role + "'>" + userData.role + "</option>";
					$("div#modifyName input").attr("value", userName);
					$("div#modifyPassword input").attr("value", userPassword);
					$("div#modifyRoles select").html(userRole);
				});
				//点击返回
				$("button#returnAllUser").on("click", function(){
					showAllUserData();
				});
				//点击丢该
				$("button#modifyUserButton").on("click", function(){
					var name = $("div#modifyName input").val();
					var role = $("div#modifyRoles select option").val();
					var password = $("div#modifyPassword input").val();
//					alert(role);
					$.post("user/modify.mvc", {no:userId, name:name, role:role, password:password}, function(re){
						alert(re);
					});
				});
			});
			
		}	
	});
})
