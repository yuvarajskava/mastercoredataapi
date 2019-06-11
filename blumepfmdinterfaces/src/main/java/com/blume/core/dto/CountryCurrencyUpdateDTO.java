package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = CountryCurrencyUpdateDTO.class)
public class CountryCurrencyUpdateDTO extends CountryCurrencyDTO {
	
	@ApiModelProperty(value = "Id of the country currency", required = false,readOnly = true)
	private String id;
	
	}
