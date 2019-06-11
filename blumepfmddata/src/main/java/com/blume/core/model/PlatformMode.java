package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "BG_Platform_Mode")
@Getter @Setter
public class PlatformMode {
	
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "modes_id")
	private double modesId;
	
	@Field(value = "mode_description")
	private String modeDescription;	
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;
	
}
