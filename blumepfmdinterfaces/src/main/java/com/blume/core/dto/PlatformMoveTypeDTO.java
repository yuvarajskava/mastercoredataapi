package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = PlatformMoveTypeDTO.class)
public class PlatformMoveTypeDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the Platform Move Type", required = false, readOnly = true)
	private String id;
	
	
	@JsonProperty(value="movetypeid")
	@ApiModelProperty(value = "moveTypeId", required = false)
	private String moveTypeId;
	
	
	@JsonProperty(value="movetypecode")
	@ApiModelProperty(value = "moveTypeCode", required = false)
	private String moveTypeCode;
	
	@JsonProperty(value="movetypename")
	@ApiModelProperty(value = "moveTypeName", required = false)
	private String moveTypeName;
	

}
