package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@JsonDeserialize(as = PlatformTripTypeUpdateDTO.class)
public class PlatformTripTypeUpdateDTO extends PlatformTripTypeDTO {
	
	@ApiModelProperty(value = "Id of the Platform Trip Type", required = false, readOnly = true)
	private String id;

}
