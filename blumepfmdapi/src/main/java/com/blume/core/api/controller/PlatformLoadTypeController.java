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
import com.blume.core.dto.PlatformLoadTypeDTO;
import com.blume.core.dto.PlatformLoadTypeUpdateDTO;
import com.blume.core.service.PlatformLoadTypeService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformloadtype")
public class PlatformLoadTypeController {
	
	@Autowired
	private PlatformLoadTypeService platformLoadTypeService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformLoadType(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {		
		List<PlatformLoadTypeDTO> platformLoadTypeDTOList = platformLoadTypeService.create((List<PlatformLoadTypeDTO>)apiRequest.getRequest());	
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformLoadTypeDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformLoadTypeDTO> platformLoadTypeDTOList = platformLoadTypeService.findAllList();			 
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformLoadTypeDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		PlatformLoadTypeDTO platformLoadTypeDTO = platformLoadTypeService.findById(id);			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformLoadTypeDTO, trackId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformLoadType(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformLoadTypeUpdateDTO platformLoadTypeUpdateDTO,@RequestParam(required = true) String trackId) {
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformLoadTypeUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformLoadType(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		platformLoadTypeService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
