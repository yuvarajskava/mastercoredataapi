package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@JsonDeserialize(as = PlatformPalletTypeDTO.class)
public class PlatformPalletTypeDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the Platform Pallet Type", required = false, readOnly = true)
	private String id;
	
	@JsonProperty(value="pallettypeid")
	@ApiModelProperty(value = "pallet Type Id", required = false)
	private double palletTypeId;
	
	
	@JsonProperty(value="palletdescription")
	@ApiModelProperty(value = "pallet Description", required = false)
	private String palletDescription;
	
	
	@JsonProperty(value="dimensionmetricmm")
	@ApiModelProperty(value = "dimension Metric(MM)", required = false)
	private String dimensionMetricMM;
	
	
	@JsonProperty(value="deimensionimperialin")
	@ApiModelProperty(value = "dimension Imperial(IN)", required = false)
	private String dimensionImperialIN;
	
	
	@JsonProperty(value="uomid")
	@ApiModelProperty(value = "UOM ID", required = false)
	private String uomId;
	
	
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
