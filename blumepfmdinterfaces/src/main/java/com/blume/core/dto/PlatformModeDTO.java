package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = PlatformModeDTO.class)
public class PlatformModeDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the Platform Mode", required = false, readOnly = true)
	private String id;
	
	@JsonProperty(value="modesid")
	@ApiModelProperty(value = "modesId", required = false)
	private double modesId;
	
	@JsonProperty(value="modedescription")
	@ApiModelProperty(value = "modeDescription", required = false)
	private String modeDescription;
	
	
}
