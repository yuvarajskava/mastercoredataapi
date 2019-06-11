package com.blume.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonDeserialize(as = EquipmentTypeUpdateDTO.class)
public class EquipmentTypeUpdateDTO extends EquipmentTypeDTO {

	@ApiModelProperty(value = "Id of the equipment size", required = false)
	private String id;

}
