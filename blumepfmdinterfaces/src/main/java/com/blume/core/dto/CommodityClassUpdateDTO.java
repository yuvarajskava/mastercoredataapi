package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = CommodityClassUpdateDTO.class)
public class CommodityClassUpdateDTO extends CommodityClassDTO {
	
	@ApiModelProperty(value = "Id of the commodity class", required = false,readOnly = true)
	private String id;
}
