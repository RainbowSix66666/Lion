
$(document).ready(function(){
	$("ul#main_menu li ul a").on("click", function(event){
		var href = $(this).attr("href");
		$("div#main_body").load(href);		
		event.preventDefault();
	});
})
