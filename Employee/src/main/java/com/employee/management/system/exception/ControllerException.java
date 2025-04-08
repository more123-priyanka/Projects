package com.employee.management.system.exception;

public class ControllerException extends RuntimeException {

	private String errorCode;
	private String errorMessage;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public ControllerException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ControllerException(String message) {
		
	}

	@Override
	public String toString() {
		return "ControllerException [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

} 
