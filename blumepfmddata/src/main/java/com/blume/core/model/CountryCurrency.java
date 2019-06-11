package com.blume.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "BG_Platform_Country_Currency")
@Getter @Setter
public class CountryCurrency {
	
	@Id
	@Field(value = "_id")
	private String id;
	
	@Field(value = "country_name")
	private String countryName;
	
	@Field(value = "iso2_code")
	private String iso2Code;
	
	@Field(value = "iso3_code")
	private String iso3Code;	
	
	@Field(value = "iso_numeric_code")
	private String isoNumericCode;
	
	@Field(value = "currency")
	private String currency;
	
	@Field(value = "currency_alphabetic_code")
	private String currencyAlphabeticCode;
	
	@Field(value = "currency_numeric_code")
	private double currencyNumericCode;
	
	@Field(value = "createdby")
	private String createdBy;
	
	@Field(value = "createdtimestamp")
	private long createdTimeStamp;
	
	@Field(value = "updatedby")
	private String updatedBy;
	
	@Field(value = "updatedtimestamp")
	private long updatedTimeStamp;

}
