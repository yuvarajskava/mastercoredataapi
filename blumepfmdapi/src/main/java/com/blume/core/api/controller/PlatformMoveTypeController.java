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
import com.blume.core.dto.PlatformMoveTypeDTO;
import com.blume.core.dto.PlatformMoveTypeUpdateDTO;
import com.blume.core.service.PlatformMoveTypeService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformmovetype")
public class PlatformMoveTypeController {
	
	@Autowired
	private PlatformMoveTypeService platformMoveTypeService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformMoveType(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {		
		List<PlatformMoveTypeDTO> platformMoveTypeDTOList = platformMoveTypeService.create((List<PlatformMoveTypeDTO>)apiRequest.getRequest());			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformMoveTypeDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformMoveTypeDTO> platformMoveTypeDTOList = platformMoveTypeService.findAllList();		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformMoveTypeDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		PlatformMoveTypeDTO platformMoveTypeDTO = platformMoveTypeService.findById(id);			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformMoveTypeDTO, trackId), HttpStatus.OK);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformMoveType(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformMoveTypeUpdateDTO platformMoveTypeUpdateDTO,@RequestParam(required = true) String trackId) throws Exception {
		
		platformMoveTypeUpdateDTO.setId(id);		
		platformMoveTypeUpdateDTO = platformMoveTypeService.update(platformMoveTypeUpdateDTO); 
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformMoveTypeUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformMoveType(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		platformMoveTypeService.delete(id);		 
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
