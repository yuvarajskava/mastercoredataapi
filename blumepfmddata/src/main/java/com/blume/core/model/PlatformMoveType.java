package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;


@Document(collection="BG_Platform_MoveType")
@Getter @Setter
public class PlatformMoveType {
	
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value="move_type_id")
	private String moveTypeId;
	
	@Field(value="move_type_code")
	private String moveTypeCode;
	
	@Field(value="move_type_name")
	private String moveTypeName;
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;
	

}
