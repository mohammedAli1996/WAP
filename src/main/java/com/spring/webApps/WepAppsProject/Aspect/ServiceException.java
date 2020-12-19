package com.spring.webApps.WepAppsProject.Aspect;

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String ErrorMsg ;
	private int ExceptionCode ; 
	
	public ServiceException() {
		super(); 
		this.ErrorMsg = "Request Failed";
		this.ExceptionCode = 500 ; 
	}
	
	
	public String getErrorMsg() {
		return ErrorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		ErrorMsg = errorMsg;
	}

	public int getExceptionCode() {
		return ExceptionCode;
	}

	public void setExceptionCode(int exceptionCode) {
		ExceptionCode = exceptionCode;
	}

	

}
