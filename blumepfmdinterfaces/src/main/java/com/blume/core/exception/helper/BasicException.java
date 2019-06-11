package com.blume.core.exception.helper;

import org.json.JSONException;
import org.json.JSONObject;

public class BasicException extends Exception  {

	private int errorCode;
	private String message;
	private String errorMessage;
	private Throwable cause;
	private JSONObject errorObject=new JSONObject();
	
	public BasicException(String message) {
        super(message);
        this.message = errorMessage;
    }
	
	public BasicException(int errorCode, String message) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
        populateErrorObject(errorCode,message);
        
    }
	
	public BasicException(int errorCode, String message, Throwable cause) {
        super(message,cause);
        this.message = message;
        this.errorCode = errorCode;
        this.cause=cause;
        populateErrorObject(errorCode,message);
    }
	
	
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
	public void populateErrorObject(int errorCode, String message) {
		try {
			errorObject.put("errorcode", errorCode);
			errorObject.put("message", message);
		} catch (JSONException e) {
		}
	}
	public String getErrorObject() {
		return errorObject.toString();
		
	}
	
}
