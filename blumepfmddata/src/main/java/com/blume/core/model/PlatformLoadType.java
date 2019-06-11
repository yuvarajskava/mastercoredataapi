package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "BG_Platform_LoadType")
@Getter @Setter
public class PlatformLoadType {
	
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "load_type_id")
	private double loadTypeId ;
	
	@Field(value = "load_type_code")
	private String loadTypeCode;
	
	@Field(value = "load_type_description")
	private String loadTypeDescription ;	
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;
	
}
