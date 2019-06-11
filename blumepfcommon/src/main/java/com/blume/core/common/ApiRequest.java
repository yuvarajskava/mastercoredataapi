package com.blume.core.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiRequest
{	
	@JsonProperty(value="trackid")
	private String trackId;
	
	private List<? extends AbstractUserOperation> request;
}
