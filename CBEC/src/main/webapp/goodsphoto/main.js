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
	var colors = null;   //选中的颜色
	//取得照片等级列表，填充照片下拉框
	$.getJSON("goodsphoto/list/photorank.mvc",function(photoList){
		$.each(photoList,function(index, photo){
			$("select#photoRank").append("<option value='"+photo.rank+"'>"+photo.rank+"</option>");
		});
	});
	
	//取得照片颜色的列表，生成复选框
	$.getJSON("photocolor/list/all/withoutphoto.mvc",function(colorList){
		$.each(colorList,function(index,cm){
			$("div#ColorCheckboxArea").append("<label class='checkbox-inline'><input type='checkbox' name='photoColor' value='"+cm.id+"'>"+cm.name+"</label>");
		});
		//照片颜色复选框点击事件处理
		$("input[type='checkbox'][name='photoColor']").on("change",function(){
			//先创建保存选中照片颜色编号的数组
			colors=new Array();
			//取得选中的角色
			$("input[type='checkbox'][name='photoColor']:checked").each(function(index,color){
				//通过$(this) 或 $(role)取得选中的复选框
				colors[index]=$(color).val();
				//colors.push($(role).val());
			});
			getParamGrid();
		});
		
	});
	
	
	//取得请求参数，并重新载入Grid数据并刷新
	function getParamGrid(){
		var datas={rank:rank, proid:photoGoodsId, photoId:matchPhotoId};
		//检查是否输入了照片上传起始日期
		if(startDate!=null){
			datas.startDate22=startDate;
		}
		//检查是否输入了照片上传截止日期
		if(endDate!=null){
			datas.endDate=endDate;
		}
		if(colors!=null&&colors.length>0){
			datas.colors=colors;
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
		getParamGrid();
		
	});
	
	//起始日期更改事件处理
	$("input#photoStartDate").on("change",function(){
		startDate=$("input#photoStartDate").val();
		alert(startDate);
		getParamGrid();
	});
	
	//结束日期更改事件处理
	$("input#photoEndDate").on("change",function(){
		endDate=$("input#photoEndDate").val();
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
         rowNum: 6,
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
			//取得照片列表生成角色复选框
			$.getJSON("photocolor/list/all/withoutphoto.mvc",function(roleList){
				$.each(roleList,function(index,rm){
					$("div#PhotoAddColorCheckBoxArea").append("<label class='checkbox-inline'><input type='checkbox' name='colors' value='"+rm.id+"'>"+rm.name+"</label>");
				});
			});
			
			//取得商品id列表，填充照片下拉框
			$.getJSON("goodsphoto/list/proid.mvc",function(photoList){
				$.each(photoList,function(index, photo){
					$("select#addProid").append("<option value='"+photo.proid+"'>"+photo.proid+"</option>");
				});
			});
			$("form#photoAddForm").validate({
				rules:{
					des:{
						required:true
					},
					loaddate:{
						required:true,
					},
					loadPhoto:{
						required:true,
						accept: "audio/*,image/*"
					}
				},
				messages:{
					des:{
						required:"描述为空"
					},
					loaddate:{
						required:"日期为空"
					},
					loadPhoto:{
						required:"照片为空",
						accept: "照片必须为图片或声音"
					}
				}
			});
			//拦截增加表单提交
			$("form#photoAddForm").ajaxForm(function(result){
				getParamGrid(); //重新载入员工列表，并刷新Grid显示。
				$("div#GoodsPhotoDialog").dialog("close"); //关闭弹出Dialog
			});
			
			//定义取消连接点击事件处理
			$("a#addCancle").on("click",function(){
				$("div#GoodsPhotoDialog").dialog("close"); //关闭弹出Dialog
			});
			
			
		
			
			/*rules:{
				loadPhoto:{
					accept: "audio/*,image/*"
				},
				des:{
					required:true
				}
				
			},
			messages:{
				loadPhoto:{
					accept: "照片必须为图片或声音"
				},
				des:{
					required:"描述为空"
				}
			}
			*/
		});	
		//加载弹窗
		$("div#GoodsPhotoDialog").dialog({
			title:"增加新员工",
			width:900,
			height:550
		});
		
	});
	
	
});