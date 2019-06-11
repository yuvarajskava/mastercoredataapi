package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformRateBasisDTO.class)
public class PlatformRateBasisDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the Platform Rate Basis", required = false, readOnly = true)
	private String id;
	
	
	@JsonProperty(value="rateid")
	@ApiModelProperty(value = "rate Id", required = false)
	private double rateId;
	
	@JsonProperty(value="code")
	@ApiModelProperty(value = "code", required = false)
	private String code;
	
	
	@JsonProperty(value="ratebasisname")
	@ApiModelProperty(value = "Rate Basis Name", required = false)
	private String rateBasisName;
	
	
	@JsonProperty(value="edimapping")
	@ApiModelProperty(value = "EDI Mapping", required = false)
	private String ediMapping;

}
