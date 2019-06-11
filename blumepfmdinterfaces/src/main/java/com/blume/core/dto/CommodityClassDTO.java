package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = CommodityClassDTO.class)
public class CommodityClassDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the commodity class", required = false, readOnly = true)
	private String id;

	@ApiModelProperty(value = "classification", required = false)	
	private String classification;
	
	@ApiModelProperty(value = "code", required = false)	
	private double code;
	
	@ApiModelProperty(value = "description", required = false)	
	private String description;
	
	@JsonProperty(value="codeparent")
	@ApiModelProperty(value = "codeParent", required = false)	
	private String codeParent;
	
	@ApiModelProperty(value = "level", required = false)	
	private double level;
	
	@JsonProperty(value="isleaf")
	@ApiModelProperty(value = "isLeaf", required = false)	
	private double isLeaf;
}
