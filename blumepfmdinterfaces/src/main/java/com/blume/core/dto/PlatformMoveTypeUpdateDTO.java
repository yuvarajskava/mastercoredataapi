package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = PlatformMoveTypeUpdateDTO.class)
public class PlatformMoveTypeUpdateDTO extends PlatformMoveTypeDTO {
	
	@ApiModelProperty(value = "Id of the Platform Move Type", required = false, readOnly = true)
	private String id;

}
