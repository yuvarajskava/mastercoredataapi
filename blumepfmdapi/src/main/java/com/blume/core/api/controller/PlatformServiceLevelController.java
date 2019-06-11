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
import com.blume.core.dto.PlatformServiceLevelDTO;
import com.blume.core.dto.PlatformServiceLevelUpdateDTO;
import com.blume.core.service.PlatformServiceLevelService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformservicelevel")
public class PlatformServiceLevelController {
	
	@Autowired
	private PlatformServiceLevelService platformServiceLevelService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformServiceLevel(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {	
		List<PlatformServiceLevelDTO> platformServiceLevelDTOList = platformServiceLevelService.create((List<PlatformServiceLevelDTO>)apiRequest.getRequest());			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformServiceLevelDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformServiceLevelDTO> platformServiceLevelDTOList = platformServiceLevelService.findAllList();		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformServiceLevelDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		PlatformServiceLevelDTO platformServiceLevelDTO = platformServiceLevelService.findById(id);			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformServiceLevelDTO, trackId), HttpStatus.OK);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformServiceLevel(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformServiceLevelUpdateDTO platformServiceLevelUpdateDTO,@RequestParam(required = true) String trackId) throws Exception {
		
		platformServiceLevelUpdateDTO.setId(id);		
		platformServiceLevelUpdateDTO = platformServiceLevelService.update(platformServiceLevelUpdateDTO);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformServiceLevelUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformServiceLevel(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		platformServiceLevelService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
