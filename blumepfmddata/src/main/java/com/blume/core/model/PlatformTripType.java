package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection="BG_Platform_TripType")
@Getter @Setter
public class PlatformTripType {
	
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "trip_type_id")
	private double tripTypeId;
	
	@Field(value = "trip_description")
	private String tripDescription;	
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;

}
