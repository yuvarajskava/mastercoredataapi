package com.blume.core.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ApiResponse 
{	
	@ApiModelProperty(value = "results", required = false)
	@JsonInclude(value=Include.NON_NULL, content=Include.NON_EMPTY)
	private List<? extends AbstractUserOperation> results;	
	
	@ApiModelProperty(value = "trackId", required = false, readOnly = true)
	@JsonProperty(value="trackid")
	private String trackId;
	
	@ApiModelProperty(value = "status", required = false, readOnly = true)
	private String status;
	
	@ApiModelProperty(value = "successmessage", required = false, readOnly = true)
	@JsonProperty(value="successmessage")
	private String successMessage;	
	
	@ApiModelProperty(value = "errormessage", required = false, readOnly = true)
	@JsonProperty(value="errormessage")
	private String errorMessage;	
	
	@ApiModelProperty(value = "successcode", required = false, readOnly = true)
	@JsonProperty(value="successcode")
	private long successCode;	
	
	@ApiModelProperty(value = "errorcode", required = false, readOnly = true)
	@JsonProperty(value="errorcode")
	private long errorCode;
	
	/*@ApiModelProperty(value = "result", required = false)
	@JsonInclude(value=Include.NON_NULL, content=Include.NON_EMPTY)
	private AbstractUserOperation result;*/
	
} 

