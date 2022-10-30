package com.springBoot.restClient.exception;

import org.springframework.http.HttpStatus;

public class BusinessResourceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private Long resourceId;
	private String errorCode;
	private String messageError;
	private String RequestURL;
	private HttpStatus status;
		
	public BusinessResourceException(String message) {
		super(message);
	}
	
	public BusinessResourceException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;
	}
	
	public BusinessResourceException(Long resourceId, String errorCode, String message) {
		super(message);
		this.resourceId = resourceId;
		this.errorCode = errorCode;
	}
	
	public BusinessResourceException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public BusinessResourceException(String errorCode, String message,HttpStatus status) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
	}

	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	public String getRequestURL() {
		return RequestURL;
	}
	public void setRequestURL(String requestURL) {
		RequestURL = requestURL;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
