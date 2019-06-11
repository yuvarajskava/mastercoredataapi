package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformServiceLevelUpdateDTO.class)
public class PlatformServiceLevelUpdateDTO extends PlatformServiceLevelDTO {
	
	@ApiModelProperty(value = "Id of the Platform Service Level", required = false, readOnly = true)
	private String id;
}
