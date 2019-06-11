package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "BG_Platform_CommodityClass")
@Getter @Setter
public class CommodityClass {
	
	@Id
	@Field(value = "_id")
	private String id;

	@Field(value = "classification")
	private String classification;
	
	@Field(value = "code")
	private double code;
	
	@Field(value = "description")
	private String description;
	
	@Field(value = "code_parent")
	private String codeParent;
	
	@Field(value = "level")
	private double level;
	
	@Field(value = "isleaf")
	private double isLeaf;
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;
}
