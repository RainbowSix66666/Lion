

$(document).ready(function(){
	
	function showData(){
		$('table#moduleGrid').jqGrid({
			//获取数据
			url: 'module/all.mvc',
	        mtype: 'GET',
			styleUI : 'Bootstrap',
	        datatype: 'json',
	        colModel: [
	        	 { label: '编号', name: 'id',  width: 50 },
	        	 { label:'模块名', name: 'name', width: 50 },
	        	 { label:'模块标签', name: 'target', width: 50 }
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
//	        	 alert(id);
	         }
		});
	}
	
	$("div#moduleContent").load("module/allmodule.html", function(){
		showData();
	});
	
	$("a#toAddModule").on("click", function(){
		//显示弹窗
		$("div#moduleDialog").dialog({
			title:"增加新模块",
			width:450,
			height:450
		});
		//加载弹窗
		$("div#moduleDialog").load("module/addmodule.html", function(){	
			//表单验证
			$("form#addModule").validate({
				//表单提交处理
				submitHandler: function(form) {
					$(form).ajaxSubmit(function() {   
					      alert("添加成功");	
					      showData();
					      $("div#moduleDialog").dialog("close");
					 });		
					//阻止表单提交跳转
					 return false; 
				  },
				
				rules:{
					name:{
						required:true,
						remote:{
							url:"module/checkname.mvc",
							type:"get",
							data:{
								name:function(){
									return $("input[name='name']").val();
								}
							}
						}
					},
					target:{
						required:true
					}
				},
				messages:{
					name:{
						required:"模块名不能为空",
						remote:"模块名已存在"
					},
					target:{
						required:"模块标签不能为空"
					}
				}
			});
			
			$("button#returnAllModule").on("click", function(){
				$("div#moduleDialog").dialog("close");
			});
		});
		
	})
	
});