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
import com.blume.core.dto.PlatformModeDTO;
import com.blume.core.dto.PlatformModeUpdateDTO;
import com.blume.core.service.PlatformModeService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformmode")
public class PlatformModeController {
	
	@Autowired
	private PlatformModeService platformModeService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformMode(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {	
		List<PlatformModeDTO> platformModeDTOList = platformModeService.create((List<PlatformModeDTO>)apiRequest.getRequest());		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformModeDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformModeDTO> platformModeDTOList = platformModeService.findAllList();			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformModeDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		PlatformModeDTO platformModeDTO = platformModeService.findById(id);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformModeDTO, trackId), HttpStatus.OK);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformMode(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformModeUpdateDTO platformModeUpdateDTO,@RequestParam(required = true) String trackId) throws Exception {
		
		platformModeUpdateDTO.setId(id);		
		platformModeUpdateDTO = platformModeService.update(platformModeUpdateDTO);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformModeUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformMode(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		platformModeService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
