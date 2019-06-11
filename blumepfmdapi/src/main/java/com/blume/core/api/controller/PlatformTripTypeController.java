package com.blume.core.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blume.core.common.ApiRequest;
import com.blume.core.common.ApiResponse;
import com.blume.core.dto.PlatformTripTypeDTO;
import com.blume.core.dto.PlatformTripTypeUpdateDTO;
import com.blume.core.service.PlatformTripTypeService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformtriptype")
public class PlatformTripTypeController {
	
	@Autowired
	private PlatformTripTypeService platformTripTypeService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformTripType(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {		 
		List<PlatformTripTypeDTO> platformTripTypeDTOList = platformTripTypeService.create((List<PlatformTripTypeDTO>) apiRequest.getRequest());			 
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformTripTypeDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformTripTypeDTO> platformTripTypeDTOList = platformTripTypeService.findAllList();			 
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformTripTypeDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		PlatformTripTypeDTO platformTripTypeDTO = platformTripTypeService.findById(id);			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformTripTypeDTO, trackId), HttpStatus.OK);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformTripType(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformTripTypeUpdateDTO platformTripTypeUpdateDTO,@RequestParam(required = true) String trackId) throws Exception {
		
		platformTripTypeUpdateDTO.setId(id);		
		platformTripTypeUpdateDTO = platformTripTypeService.update(platformTripTypeUpdateDTO);
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformTripTypeUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformTripType(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		platformTripTypeService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}
}
