
$(document).ready(function(){
	$("ul#main_menu li ul a").on("click", function(event){
		var href = $(this).attr("href");
//		href = "User/main.html";
		alert(href);
		$("div#main_body").load(href);		
		event.preventDefault();
	});
})
