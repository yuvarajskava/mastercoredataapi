package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformPalletTypeUpdateDTO.class)
public class PlatformPalletTypeUpdateDTO extends PlatformPalletTypeDTO {
	
	@ApiModelProperty(value = "Id of the Platform Pallet Type", required = false, readOnly = true)
	private String id;
}
