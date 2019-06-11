package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@JsonDeserialize(as = PlatformTripTypeDTO.class)
public class PlatformTripTypeDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the Platform Trip Type", required = false, readOnly = true)
	private String id;
	
	@JsonProperty(value="triptypeid")
	@ApiModelProperty(value = "Trip Type ID", required = false)
	private double tripTypeId;
	
	
	@JsonProperty(value="tripdescription")
	@ApiModelProperty(value = "Trip Description", required = false)
	private String tripDescription;

}
