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
import com.blume.core.dto.CommodityClassDTO;
import com.blume.core.dto.CommodityClassUpdateDTO;
import com.blume.core.service.CommodityClassService;
import com.blume.core.utils.ResponseHelper;





@RestController
@RequestMapping("/commodityclass")
public class CommodityClassController {	
	
	
	@Autowired(required=true)
	private CommodityClassService commodityClassService;
	
	

	@PostMapping("/")
	public ResponseEntity<com.blume.core.common.ApiResponse> createCommodityClass(			
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {		
		 		
		List<CommodityClassDTO>   commodityClassDTOList = commodityClassService.create((List<CommodityClassDTO>)apiRequest.getRequest());		
		return new ResponseEntity<>(ResponseHelper.constructResponse(commodityClassDTOList, trackId) , HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception{		
		List<CommodityClassDTO> commodityClassDTOList = commodityClassService.findAllList();			
		return new ResponseEntity<>(ResponseHelper.constructResponse(commodityClassDTOList, trackId), HttpStatus.OK);
	}
	
	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,@RequestParam(required = true) String id) throws Exception{
		CommodityClassDTO commodityClassDTO = commodityClassService.findById(id);			
		return new ResponseEntity<>(ResponseHelper.constructResponse(commodityClassDTO, trackId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateCommodityClass(@RequestParam(required = true) String id,
			@RequestBody(required = true) CommodityClassUpdateDTO commodityClassUpdateDTO,@RequestParam(required = true) String trackId) throws Exception{
		commodityClassUpdateDTO.setId(id);
		commodityClassUpdateDTO = commodityClassService.update(commodityClassUpdateDTO);
		return new ResponseEntity<>(ResponseHelper.constructResponse(commodityClassUpdateDTO, trackId), HttpStatus.OK);
	}
	
	@PostMapping("/updateall")
	public ResponseEntity<ApiResponse> updateallCommodityClass (			
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {		
		List<CommodityClassDTO> commodityClassDTOList = commodityClassService.create((List<CommodityClassDTO>)apiRequest.getRequest());		
		return new ResponseEntity<>(ResponseHelper.constructResponse(commodityClassDTOList, trackId) , HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteCommodityClass(@PathVariable String id, @RequestParam(required = true) String trackId) throws Exception{
		commodityClassService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
