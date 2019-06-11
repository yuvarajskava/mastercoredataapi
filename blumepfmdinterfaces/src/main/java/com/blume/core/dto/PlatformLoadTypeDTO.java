package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformLoadTypeDTO.class)
public class PlatformLoadTypeDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the PlatformLoadType", required = false, readOnly = true)
	private String id;
	
	@ApiModelProperty(value = "loadTypeId", required = false)
	@JsonProperty(value="loadtypeid")
	private double loadTypeId ;
	
	@ApiModelProperty(value = "loadTypeCode", required = false)
	@JsonProperty(value="loadtypecode")
	private String loadTypeCode;
	
	@ApiModelProperty(value = "loadTypeDescription", required = false)
	@JsonProperty(value="loadtypedescription")
	private String loadTypeDescription ;
	
	
}
