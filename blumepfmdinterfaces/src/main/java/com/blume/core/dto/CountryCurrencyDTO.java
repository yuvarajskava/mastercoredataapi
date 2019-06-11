package com.blume.core.dto;

import com.blume.core.common.AbstractUserOperation;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonDeserialize(as = CountryCurrencyDTO.class)
public class CountryCurrencyDTO extends AbstractUserOperation {
	
	@ApiModelProperty(value = "Id of the country currency", required = false, readOnly = true)	
	private String id;
	
	@ApiModelProperty(value = "Country Name", required = false)	
	@JsonProperty(value="countryname")
	private String countryName;
	
	@ApiModelProperty(value = "ISO 2 Code", required = false)	
	@JsonProperty(value="iso2code")
	private String iso2Code;
	
	@ApiModelProperty(value = "ISO 3 Code", required = false)	
	@JsonProperty(value="iso3code")
	private String iso3Code;	
	
	@ApiModelProperty(value = "ISO Numeric Code", required = false)	
	@JsonProperty(value="isonumericcode")
	private String isoNumericCode;
	
	@ApiModelProperty(value = "Currency", required = false)	
	@JsonProperty(value="currency")
	private String currency;
	
	@ApiModelProperty(value = "Currency Alphabetic Code", required = false)	
	@JsonProperty(value="currencyalphabeticcode")
	private String currencyAlphabeticCode;
	
	@ApiModelProperty(value = "currencyNumericCode", required = false)	
	@JsonProperty(value="currencynumericcode")
	private double currencyNumericCode;

}
