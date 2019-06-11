package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = PlatformUOMDTO.class)
public class PlatformUOMDTO extends AbstractUserOperation {	
	
	@ApiModelProperty(value = "Id of the Platform UOM", required = false, readOnly = true)
	private String id;
	
	@JsonProperty(value="uomid")
	@ApiModelProperty(value = "UOM ID", required = false)
	private double uomId;
	
	@JsonProperty(value="uomcode")
	@ApiModelProperty(value = "UOM Code", required = false)
	private String uomCode;
	
	@JsonProperty(value="uomdescription")
	@ApiModelProperty(value = "UOM Description", required = false)
	private String uomDescription;
	
	@JsonProperty(value="uomqualifier")
	@ApiModelProperty(value = "UOM Qualifier", required = false)
	private String uomQualifier;

}
