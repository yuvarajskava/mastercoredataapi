package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;


@Document(collection="BG_Platform_ServiceLevel")
@Getter @Setter
public class PlatformServiceLevel {
	
	@Id
	@Field(value = "_id")
	private String id;
		
	@Field(value = "service_level_id")
	private double serviceLevelId;
	
	@Field(value = "service_level_name")
	private String serviceLevelName;
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;
}
