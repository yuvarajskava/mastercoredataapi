package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "BG_Platform_EquipmentType")
@Getter
@Setter
public class EquipmentType {

	@Id
	@Field(value = "_id")
	private String id;

	@Field(value = "size_type_code")
	private String sizeTypeCode;

	@Field(value = "size_type_name")
	private String sizeTypeName;

	@Field(value = "equipment_class_code")
	private String equipmentClassCode;

	@Field(value = "equipment_class_description")
	private String equipmentClassDescription;

	@Field(value = "height")
	private String height;

	@Field(value = "width")
	private String width;

	@Field(value = "depth")
	private String depth;
	
	@Field(value = "uom_id")
	private String uomId;
	
	@Field(value = "uom_code")
	private String uomCode;
	
	@Field(value = "uom_description")
	private String uomDescription;
	
	@Field(value = "uom_qualifier")
	private String uomQualifier;
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;

}
