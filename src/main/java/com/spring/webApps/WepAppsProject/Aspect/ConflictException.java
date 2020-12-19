package com.spring.webApps.WepAppsProject.Aspect;

public class ConflictException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String ErrorMsg ;
	private int ExceptionCode ; 
	

	public ConflictException() {
		super(); 
		this.ErrorMsg = "cannot update this record";
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
