package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformRateBasisUpdateDTO.class)
public class PlatformRateBasisUpdateDTO extends PlatformRateBasisDTO {
	
	@ApiModelProperty(value = "Id of the Platform Rate Basis", required = false, readOnly = true)
	private String id; 

}
