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
import com.blume.core.dto.PlatformRateBasisDTO;
import com.blume.core.dto.PlatformRateBasisUpdateDTO;
import com.blume.core.service.PlatformRateBasisService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/platformratebasis")
public class PlatformRateBasisController {

	@Autowired
	private PlatformRateBasisService platformRateBasisService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createPlatformRateBasis(@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformRateBasisDTO> platformRateBasisDTOList = platformRateBasisService
				.create((List<PlatformRateBasisDTO>) apiRequest.getRequest());
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformRateBasisDTOList, trackId),
				HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<PlatformRateBasisDTO> platformRateBasisDTOList = platformRateBasisService.findAllList();
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformRateBasisDTOList, trackId), HttpStatus.OK);
	}

	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,
			@RequestParam(required = true) String id) throws Exception {
		PlatformRateBasisDTO platformRateBasisDTO = platformRateBasisService.findById(id);
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformRateBasisDTO, trackId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updatePlatformRateBasis(@RequestParam(required = true) String id,
			@RequestBody(required = true) PlatformRateBasisUpdateDTO platformRateBasisUpdateDTO,
			@RequestParam(required = true) String trackId) throws Exception {

		platformRateBasisUpdateDTO.setId(id);
		platformRateBasisUpdateDTO = platformRateBasisService.update(platformRateBasisUpdateDTO);
		return new ResponseEntity<>(ResponseHelper.constructResponse(platformRateBasisUpdateDTO, trackId),
				HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deletePlatformRateBasis(@PathVariable String id,
			@RequestParam(required = true) String trackId) throws Exception {
		platformRateBasisService.delete(id);
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}
}
