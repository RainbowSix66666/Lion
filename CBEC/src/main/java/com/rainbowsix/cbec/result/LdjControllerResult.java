package com.rainbowsix.cbec.result;
/*
 * 练习登录界面
 * 控制器返回结果对象
 */
public class LdjControllerResult {
private String status=null; //正常 OK, 异常:ERROR
	
	
	private String message=null; //消息信息，如有异常，异常message, 没有异常自己定义。
	private Exception exception=null;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Exception getException() {
		return exception;
	}
	public void setException(Exception exception) {
		this.exception = exception;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
