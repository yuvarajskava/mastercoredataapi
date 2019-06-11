package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;


@Document(collection="BG_Platform_RateBasis")
@Getter @Setter
public class PlatformRateBasis {
	
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "rate_id")
	private double rateId;
	
	@Field(value = "code")
	private String code;
	
	@Field(value = "rate_basis_name")
	private String rateBasisName;
	
	@Field(value = "edi_mapping")
	private String ediMapping;
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;

}
