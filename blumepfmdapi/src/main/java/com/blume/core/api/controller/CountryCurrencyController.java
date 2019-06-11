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
import com.blume.core.dto.CountryCurrencyDTO;
import com.blume.core.dto.CountryCurrencyUpdateDTO;
import com.blume.core.service.CountryCurrencyService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/countrycurrency")
public class CountryCurrencyController {
	
	@Autowired
	private CountryCurrencyService countryCurrencyService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createCountryCurrency(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception{		
		
		List<CountryCurrencyDTO> countryCurrencyList = countryCurrencyService.create((List<CountryCurrencyDTO>)apiRequest.getRequest());	
		return new ResponseEntity<>(ResponseHelper.constructResponse(countryCurrencyList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<CountryCurrencyDTO> countryCurrencyDTOList = countryCurrencyService.findAllList();			
		return new ResponseEntity<>(ResponseHelper.constructResponse(countryCurrencyDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception {
		CountryCurrencyDTO countryCurrencyDTO = countryCurrencyService.findById(id);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(countryCurrencyDTO, trackId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateCountryCurrency(@RequestParam(required = true) String id,
		@RequestBody(required = true) CountryCurrencyUpdateDTO countryCurrencyUpdateDTO,@RequestParam(required = true) String trackId) throws Exception {
		
		countryCurrencyUpdateDTO = countryCurrencyService.update(countryCurrencyUpdateDTO);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(countryCurrencyUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteCountryCurrency(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception {
		countryCurrencyService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
