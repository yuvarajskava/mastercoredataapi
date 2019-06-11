package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = PlatformUOMUpdateDTO.class)
public class PlatformUOMUpdateDTO extends PlatformUOMDTO{	
	
	@ApiModelProperty(value = "Id of the Platform UOM", required = false, readOnly = true)
	private String id;
}
