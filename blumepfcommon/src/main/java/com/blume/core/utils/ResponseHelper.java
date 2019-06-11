package com.blume.core.utils;

import java.util.ArrayList;
import java.util.List;

import com.blume.core.common.AbstractUserOperation;
import com.blume.core.common.ApiResponse;

public class ResponseHelper 
{	
	public static ApiResponse getDefaultResponse(String trackId)
	{
		ApiResponse apiResponse = new ApiResponse();

		if(trackId != null)
			apiResponse.setTrackId(trackId);

		apiResponse.setStatus(ResponseModelConstants.SUCCESS_STATUS);
		apiResponse.setSuccessMessage(ResponseModelConstants.SUCCESS_MESSAGE);
		apiResponse.setSuccessCode(200);

		return apiResponse;
	}
	
	public static ApiResponse constructResponse(AbstractUserOperation abstractUserOperation, String trackId)
	{
		List<AbstractUserOperation> abstractUserOperationList = new ArrayList();

		if(abstractUserOperation != null)
			abstractUserOperationList.add(abstractUserOperation);
		
		return constructResponse(abstractUserOperationList, trackId);
	}

	public static ApiResponse constructResponse(List<? extends AbstractUserOperation> abstractUserOperationList, String trackId)
	{

		ApiResponse apiResponse = getDefaultResponse(trackId);
		apiResponse.setResults(abstractUserOperationList);

		return apiResponse; 
	}
}
