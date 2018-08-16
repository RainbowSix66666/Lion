//商品页面加载成功事件
$(document).ready(function(){
	var proid=0;
	//alert("成功加载");
	
			$.getJSON("goods/select/all.mvc",function(all){
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
						//修改响应
						$("button#modify").on("click",function(){
							//alert(proid);
							$("div#main_body").load("goods/modify.html", function(){
						//	alert("点击修改成功");
							$.getJSON("goods/select/one.mvc",{proid:proid},function(resultData){
								//alert("进入修改函数");
								var title=resultData.title
								//alert(title);
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
										//取得输入的值
										var title =$("input[name='title']").val();
										var comid = $("input[name='comid']").val();
										var price = $("input[name = 'price']").val();
										var state = $("input[name = 'state']").val();
										var goodsdate = $("input[name = 'gooddate']").val();
										var type = $("input[name = 'type']").val();
										var stock = $("input[name = 'stock']").val();
										var weight = $("input[name = 'weight']").val();
										var gooddesc = $("input[name = 'gooddesc']").val();
										
										$.post("goods/modify.mvc",{proid:proid,comid:comid,title:title,price:price,state:state,gooddate:gooddate,type:type,stock:stock,weight:weight,gooddesc:gooddesc});
										
										alert("修改完成");
									});
							});
});
					});	
					event.preventDefault();
				})
			});	
});

//添加响应
$("a#addgoods").on("click", function(){
	$("div#main_body").load("goods/add.html", function(){
		//点击添加商品
		$("button#addgoods").on("click", function(){
			alert("进入增加函数");
			var title =$("input[name='title']").val();
			var comid = $("input[name='comid']").val();
			var price = $("input[name = 'price']").val();
			var state = $("input[name = 'state']").val();
			var gooddate = $("input[name = 'gooddate']").val();
			var type = $("input[name = 'type']").val();
			var stock = $("input[name = 'stock']").val();
			var weight = $("input[name = 'weight']").val();
			var gooddesc = $("input[name = 'gooddesc']").val();

			alert(title);
			$.post("goods/add.mvc", {title:title,comid:comid,price:price,gooddate:gooddate,state:state,type:type,stock:stock,weight:weight,gooddesc:gooddesc}, function(re){
				
				if(re == 'OK'){
					alert("添加成功");
					$("div#main_body").load("goods/showall.html");
				}else{
					alert("添加失败");
				}
			});
		})
	});
})



	