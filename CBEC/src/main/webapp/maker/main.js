$(document).ready(function(){
		//页面操作代码区
		$("ul#demo1 li a").on("click",function(event){
			var href = $(this).attr("href");
			alert(href);
			$("div#main_body").load(href);
			event.preventDefault();
		});
});
