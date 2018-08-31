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
		            		"<a id='goodInfo' href=goods/buygood.html proid='"+all[i].proid+"'><img class='img-thumbnail' src='http://placehold.it/200x200' alt=''/></a>"+
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
								
							//收藏响应
						$("button#like").on("click",function(){
							$.post("xxx.mvc");
							alert("收藏成功");
							$("div#main_body").load("xxx.html");
						});
							
							//购买响应
							$("button#buy").on("click",function(){
							$.post("goods/buygood.mvc",{proid:proid,count:count});
							alert("下单成功");
							$("div#main_body").load("xxx.html");
							});
						});	
						event.preventDefault();
					});
				});
			})
			
			$.getJSON("goods/select/all.mvc",function(all){
				var title="";
				for(var i=0;i<all.length;i++){
					
					title=title + "<div class='col-lg-2'>" + "<div class='panel panel-primary'>" +
	           "<div class='panel-heading' id='title'>" +
	                		"<h3 class='panel-title'><i class='fa fa-shopping-cart'>"+all[i].title+"</i></h3>"+
	            		"</div>"+
	            		"<div>"+
	            		"<a id='goodInfo' href=goods/buygood.html proid='"+all[i].proid+"'><img class='img-thumbnail' src='http://placehold.it/200x200' alt=''/></a>"+
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
						
						//收藏响应
						$("button#like").on("click",function(){
							$.post("xxx.mvc");
							alert("收藏成功");
							$("div#main_body").load("xxx.html");
						});
						
						//购买响应
						$("button#buy").on("click",function(){
							$.post("goods/buygood.mvc",{proid:proid,count:count});
							alert("下单成功");
							$("div#main_body").load("xxx.html");
						});
					});	
					event.preventDefault();
				});
			});				
});





	