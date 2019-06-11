package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformLoadTypeUpdateDTO.class)
public class PlatformLoadTypeUpdateDTO extends PlatformLoadTypeDTO {
	
	@ApiModelProperty(value = "Id of the PlatformLoadType", required = false,readOnly = true)
	private String id;	
		
}
