package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformServiceLevelDTO.class)
public class PlatformServiceLevelDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the Platform Service Level", required = false, readOnly = true)
	private String id;
	
	@JsonProperty(value="servicelevelid")
	@ApiModelProperty(value = "Service Level ID", required = false)
	private double serviceLevelId;
	
	
	@JsonProperty(value="servicelevelname")
	@ApiModelProperty(value = "Service Level Name", required = false)
	private String serviceLevelName;
	

}
