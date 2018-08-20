/**
 * jQuery Validate OA项目的定制验证规则
 */
$.validator.addMethod("rangelengthForOA",function(value,element,params){
	var min=params[0];
	var max=params[1];
	var result=false;
	if(value!=null&&value.length>=min&&value.length<=max){
		result=true;
	}
	return this.optional(element) ||result;
	
},"要求长度必须满足要求(定制)");

$.validator.addMethod("mobile",function(value,element){
	
	var result=false;
	var pattern=/^[1][3,4,5,7,8][0-9]{9}$/;
	if(pattern.test(value)){
		result=true;
	}
	
	return this.optional(element) ||result;
	
},"手机号码不合法");

//


