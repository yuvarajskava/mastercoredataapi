package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection="BG_Platform_UOM")
@Getter @Setter
public class PlatformUOM {
	
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "uom_id")
	private double uomId;
	
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
