package com.blume.core.exception.helper;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.blume.core.common.ApiResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class BasicExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicExceptionHandler.class);
	
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(BasicException.class)
    public ResponseEntity<String> handleUserNotFoundException(BasicException ex) {
        return new ResponseEntity<>(ex.getErrorObject(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception exc,WebRequest request) {		
		ApiResponse apiResponse = new ApiResponse();		
		apiResponse.setStatus("Failure");
		
		String message = ExceptionUtils.getRootCauseMessage(exc.getCause());
		LOGGER.error(message, exc);
		
		Throwable ex = ExceptionUtils.getRootCause(exc.getCause());
		if(message.contains("MongoTimeoutException"))
		{
			apiResponse.setErrorCode(1001);
			apiResponse.setErrorMessage(messageSource.getMessage("1001", null,null));
		}
		else if(ex instanceof InvalidFormatException)
		{
			apiResponse.setErrorCode(2003);
			apiResponse.setErrorMessage(messageSource.getMessage("2001", null,null));
		}
		else if(ex instanceof JsonParseException || ex instanceof JSONException || ex instanceof JsonMappingException )
		{
			apiResponse.setErrorCode(2001);
			apiResponse.setErrorMessage(messageSource.getMessage("2002", null,null));
		}		
		else if(ex instanceof NullPointerException)
		{
			apiResponse.setErrorCode(2002);
			apiResponse.setErrorMessage(messageSource.getMessage("2003", null,null));
		}		
		else
		{
			apiResponse.setErrorCode(1000);
			apiResponse.setErrorMessage("Unknown Failure");
		}
		apiResponse.setTrackId(request.getParameter("trackId"));
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
}
