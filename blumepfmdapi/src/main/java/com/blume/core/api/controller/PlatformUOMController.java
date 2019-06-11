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
import com.blume.core.dto.PlatformUOMDTO;
import com.blume.core.dto.PlatformUOMUpdateDTO;
import com.blume.core.service.PlatformUOMService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformuom")
public class PlatformUOMController {
	
	@Autowired
	private PlatformUOMService platformUOMService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformUOM(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformUOMDTO> platformUOMDTOList = platformUOMService.create((List<PlatformUOMDTO>)apiRequest.getRequest());		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformUOMDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformUOMDTO> platformUOMDTOList = platformUOMService.findAllList();			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformUOMDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		PlatformUOMDTO platformUOMDTO = platformUOMService.findById(id);			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformUOMDTO, trackId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformUOM(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformUOMUpdateDTO platformUOMUpdateDTO,@RequestParam(required = true) String trackId) throws Exception {
		
		platformUOMUpdateDTO.setId(id);		
		platformUOMUpdateDTO = platformUOMService.update(platformUOMUpdateDTO);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformUOMUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformUOM(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		platformUOMService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}
}
