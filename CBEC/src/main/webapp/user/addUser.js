$(document).ready(function(){	
	$.getJSON("role/all.mvc", function(roleList){
		var options = "";
		for(var i = 0; i < roleList.length; ++i){
			options = options + "<option value="+ roleList[i].name
			+">" + roleList[i].name + "</option>";
		}
		$("select#roles_select").html(options);
	})
});