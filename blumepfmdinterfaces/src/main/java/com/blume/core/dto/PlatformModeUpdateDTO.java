package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = PlatformModeUpdateDTO.class)
public class PlatformModeUpdateDTO extends PlatformModeDTO {
	
	@ApiModelProperty(value = "Id of the Platform Mode", required = false, readOnly = true)
	private String id;
}
