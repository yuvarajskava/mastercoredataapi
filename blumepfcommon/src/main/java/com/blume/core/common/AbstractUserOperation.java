package com.blume.core.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class AbstractUserOperation {
	
	@ApiModelProperty(value = "createdBy", required = false)
	@JsonProperty(value="createdby")
	private String createdBy;
	
	@ApiModelProperty(value = "createdTimeStamp", required = false, readOnly = true)
	@JsonProperty(value="createdtimestamp")
	private long createdTimeStamp;
	
	@ApiModelProperty(value = "updatedBy", required = false)
	@JsonProperty(value="updatedby")
	private String updatedBy;
	
	@ApiModelProperty(value = "updatedTimeStamp", required = false, readOnly = true)
	@JsonProperty(value="updatedtimestamp")
	private long updatedTimeStamp;	

}
