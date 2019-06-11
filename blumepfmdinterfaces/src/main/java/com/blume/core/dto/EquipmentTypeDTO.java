package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonDeserialize(as = EquipmentTypeDTO.class)
public class EquipmentTypeDTO extends AbstractUserOperation {

	@ApiModelProperty(value = "Id of the equipment size", required = false, readOnly = true)
	private String id;
	
	@JsonProperty(value="sizetypecode")
	@ApiModelProperty(value = "size type", required = false)
	private String sizeTypeCode;

	@ApiModelProperty(value = "size_type_name", required = false)
	@JsonProperty(value="sizetypename")
	private String sizeTypeName;

	@ApiModelProperty(value = "equipment_class_code", required = false)
	@JsonProperty(value="equipmentclasscode")
	private String equipmentClassCode;

	@ApiModelProperty(value = "equipment_class_description", required = false)
	@JsonProperty(value="equipmentclassdescription")
	private String equipmentClassDescription;

	@ApiModelProperty(value = "height", required = false)
	private String height;

	@ApiModelProperty(value = "width", required = false)
	private String width;

	@ApiModelProperty(value = "depth", required = false)
	private String depth;	 
	
	@ApiModelProperty(value = "UOM ID", required = false)
	@JsonProperty(value="uomid")
	private String uomId;
	
	@ApiModelProperty(value = "UOM Code", required = false)
	@JsonProperty(value="uomcode")
	private String uomCode;
	
	@ApiModelProperty(value = "UOM Description", required = false)
	@JsonProperty(value="uomdescription")
	private String uomDescription;
	
	@ApiModelProperty(value = "UOM Qualifier", required = false)
	@JsonProperty(value="uomqualifier")
	private String uomQualifier;
}
