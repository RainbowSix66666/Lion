//商品页面加载成功事件
$(document).ready(function(){
	var proid=0;
	//alert("成功加载");
	
	
			//获取商品类型填充下拉列表
			$.getJSON("goods/select/alltype.mvc",function(all){
				var option="<option value='0'>所有</option>";
				$.each(all,function(index,good){
					
					option=option+"<option value='"+good.typeno+"'>"+good.type+"</option>"
				});
				$("select#type").html(option);
			});
			
			//商品类型选择框变化响应
			$("select#type").on("change",function(){
				typeno=$("select#type").val();
//				alert(typeno);
				$.getJSON("goods/select/bytype.mvc",{typeno:typeno},function(all){
					var title="";
					for(var i=0;i<all.length;i++){
						
						title=title + "<div class='col-lg-2'>" + "<div class='panel panel-primary'>" +
		           "<div class='panel-heading' id='title'>" +
		                		"<h3 class='panel-title'><i class='fa fa-shopping-cart'>"+all[i].title+"</i></h3>"+
		            		"</div>"+
		            		"<div>"+
		            		"<a id='goodInfo' href=goods/goodInfo.html proid='"+all[i].proid+"'><img class='img-thumbnail' src='http://placehold.it/200x200' alt=''/></a>"+
		            		"</div>"+
		        		"</div>"+
		    		"</div>"
						//title=title+"<tr data-no='"+all[i].proid+"'><td>"+all[i].title+"</td></tr>"
		 			}
					$("div#goodsall").html(title);
					$("a#goodInfo").on("click",function(){
						var href = $(this).attr("href");
						proid=$(this).attr("proid");
						$("div#main_body").load(href,function(){
							//alert(proid);
							$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
								var title=resultData.title
										//将原有的值显示
										var gooddate=resultData.gooddate;
										$("input[name='comid']").val(resultData.comid);
										$("input[name='title']").val(resultData.title);
										$("input[name='price']").val(resultData.price);
										$("input[name='state']").val(resultData.state);
										$("input[name='stock']").val(resultData.stock);
										$("input[name='gooddate']").val(gooddate);
										$("input[name='type']").val(resultData.type);
										$("input[name='weight']").val(resultData.weight);
										$("input[name='gooddesc']").val(resultData.gooddesc);
										alert(gooddate);
									});
							//修改响应
							$("button#modify").on("click",function(){
								//alert("点击修改成功");
								//alert(proid);
								$("div#main_body").load("goods/modify.html", function(){
								//alert("进入修改成功");
								$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
									//alert("进入修改函数");
									var title=resultData.title
									//alert("显示单个商品信息");
											//将原有的值显示
											$("input[name='comid']").val(resultData.comid);
											$("input[name='title']").val(resultData.title);
											$("input[name='price']").val(resultData.price);
											$("input[name='state']").val(resultData.state);
											$("input[name='stock']").val(resultData.stock);
											$("input[name='gooddate']").val(resultData.gooddate);
											$("input[name='type']").val(resultData.type);
											$("input[name='weight']").val(resultData.weight);
											$("input[name='gooddesc']").val(resultData.gooddesc);
										});
								$("button#modifygoods").on("click",function(){
											//alert("怎么回事");
											//取得输入的值
											var title =$("input[name='title']").val();
											var comid = $("input[name='comid']").val();
											var price = $("input[name = 'price']").val();
											var state = $("input[name = 'state']").val();
											var gooddate = $("input[name = 'gooddate']").val();
											var type = $("input[name = 'type']").val();
											var stock = $("input[name = 'stock']").val();
											var weight = $("input[name = 'weight']").val();
											var gooddesc = $("input[name = 'gooddesc']").val();
											//alert("准备进入修改函数");
											$.post("goods/modify.mvc",{proid:proid,comid:comid,title:title,price:price,state:state,gooddate:gooddate,type:type,stock:stock,weight:weight,gooddesc:gooddesc});
											
											//alert("修改完成");
										});
								});
							});
							
							//删除响应
							$("button#del").on("click",function(){
								$.post("goods/del.mvc",{proid:proid});
								alert("删除成功");
								$("div#main_body").load("goods/showall.html");
							});
						});	
						event.preventDefault();
					});
				});
			})
			
			$.getJSON("goods/select/bycomid.mvc",{comid:comid},function(all){
				var title="";
				for(var i=0;i<all.length;i++){
					
					title=title + "<div class='col-lg-2'>" + "<div class='panel panel-primary'>" +
	           "<div class='panel-heading' id='title'>" +
	                		"<h3 class='panel-title'><i class='fa fa-shopping-cart'>"+all[i].title+"</i></h3>"+
	            		"</div>"+
	            		"<div>"+
	            		"<a id='goodInfo' href=goods/goodInfo.html proid='"+all[i].proid+"'><img class='img-thumbnail' src='http://placehold.it/200x200' alt=''/></a>"+
	            		"</div>"+
	        		"</div>"+
	    		"</div>"
					//title=title+"<tr data-no='"+all[i].proid+"'><td>"+all[i].title+"</td></tr>"
	 			}
				$("div#goodsall").html(title);
				$("a#goodInfo").on("click",function(){
					var href = $(this).attr("href");
					proid=$(this).attr("proid");
					$("div#main_body").load(href,function(){
						//alert(proid);
						$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
							var title=resultData.title
									//将原有的值显示
									var gooddate=resultData.gooddate;
									$("input[name='comid']").val(resultData.comid);
									$("input[name='title']").val(resultData.title);
									$("input[name='price']").val(resultData.price);
									$("input[name='state']").val(resultData.state);
									$("input[name='stock']").val(resultData.stock);
									$("input[name='gooddate']").val(gooddate);
									$("input[name='type']").val(resultData.type);
									$("input[name='weight']").val(resultData.weight);
									$("input[name='gooddesc']").val(resultData.gooddesc);
									alert(gooddate);
								});
						//修改响应
						$("button#modify").on("click",function(){
							//alert("点击修改成功");
							//alert(proid);
							$("div#main_body").load("goods/modify.html", function(){
							//alert("进入修改成功");
							$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
								//alert("进入修改函数");
								var title=resultData.title
								//alert("显示单个商品信息");
										//将原有的值显示
										$("input[name='comid']").val(resultData.comid);
										$("input[name='title']").val(resultData.title);
										$("input[name='price']").val(resultData.price);
										$("input[name='state']").val(resultData.state);
										$("input[name='stock']").val(resultData.stock);
										$("input[name='gooddate']").val(resultData.gooddate);
										$("input[name='type']").val(resultData.type);
										$("input[name='weight']").val(resultData.weight);
										$("input[name='gooddesc']").val(resultData.gooddesc);
									});
							$("button#modifygoods").on("click",function(){
										//alert("怎么回事");
										//取得输入的值
										var title =$("input[name='title']").val();
										var comid = $("input[name='comid']").val();
										var price = $("input[name = 'price']").val();
										var state = $("input[name = 'state']").val();
										var gooddate = $("input[name = 'gooddate']").val();
										var type = $("input[name = 'type']").val();
										var stock = $("input[name = 'stock']").val();
										var weight = $("input[name = 'weight']").val();
										var gooddesc = $("input[name = 'gooddesc']").val();
										//alert("准备进入修改函数");
										$.post("goods/modify.mvc",{proid:proid,comid:comid,title:title,price:price,state:state,gooddate:gooddate,type:type,stock:stock,weight:weight,gooddesc:gooddesc});
										
										//alert("修改完成");
									});
							});
						});
						
						//删除响应
						$("button#del").on("click",function(){
							$.post("goods/del.mvc",{proid:proid});
							alert("删除成功");
							$("div#main_body").load("goods/showall.html");
						});
					});	
					event.preventDefault();
				});
			});	
			
			//
			$("button#add").on("click",function(){
				$("div#GoodsDialog").load("goods/add.html",function(){
					$("form#add").ajaxForm(function(result){
						alert(result);
						$("div#main_body").load("goods/showall.html");
					});
					return false;
				});

				$("div#GoodsDialog").dialog({
					title:"新增商品",
					width:900,
					height:350
				});
				
			});
});





	