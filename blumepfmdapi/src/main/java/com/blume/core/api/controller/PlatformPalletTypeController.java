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
import com.blume.core.dto.PlatformPalletTypeDTO;
import com.blume.core.dto.PlatformPalletTypeUpdateDTO;
import com.blume.core.service.PlatformPalletTypeService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformpallettype")
public class PlatformPalletTypeController {
	
	@Autowired
	private PlatformPalletTypeService platformPalletTypeService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformPalletType(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {		
		List<PlatformPalletTypeDTO> platformPalletTypeDTOList = platformPalletTypeService.create((List<PlatformPalletTypeDTO>)apiRequest.getRequest());		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformPalletTypeDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformPalletTypeDTO> platformPalletTypeDTOList = platformPalletTypeService.findAllList();		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformPalletTypeDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		PlatformPalletTypeDTO platformPalletTypeDTO = platformPalletTypeService.findById(id);			
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformPalletTypeDTO, trackId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformPalletType(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformPalletTypeUpdateDTO platformPalletTypeUpdateDTO,@RequestParam(required = true) String trackId) throws Exception {
		
	 	platformPalletTypeUpdateDTO = platformPalletTypeService.update(platformPalletTypeUpdateDTO);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformPalletTypeUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformPalletType(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		platformPalletTypeService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
