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
import com.blume.core.dto.EquipmentTypeDTO;
import com.blume.core.dto.EquipmentTypeUpdateDTO;
import com.blume.core.service.EquipmentTypeService;
import com.blume.core.utils.ResponseHelper;

@RestController
@RequestMapping("/equipmenttype")
public class EquipmentTypeController {

	@Autowired
	private EquipmentTypeService equipmentTypeService;

	@PostMapping("/")
	public ResponseEntity<ApiResponse> createEquipmentType(
			@RequestBody(required = true) ApiRequest apiRequest,
			@RequestParam(required = true) String trackId) throws Exception {	
		@SuppressWarnings("unchecked")
		List<EquipmentTypeDTO> equipmentTypeDTOList = equipmentTypeService.create((List<EquipmentTypeDTO>)apiRequest.getRequest());
		return new ResponseEntity<>(ResponseHelper.constructResponse(equipmentTypeDTOList, trackId), HttpStatus.CREATED);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ApiResponse> findAllList(@RequestParam(required = true) String trackId) throws Exception {
		List<EquipmentTypeDTO> equipmentTypeDTOList = equipmentTypeService.findAllList();		
		return new ResponseEntity<>(ResponseHelper.constructResponse(equipmentTypeDTOList, trackId), HttpStatus.OK);
	}

	@GetMapping("/viewbyid/{id}")
	public ResponseEntity<ApiResponse> findById(@RequestParam(required = true) String trackId,
			@RequestParam(required = true) String id) throws Exception {
		EquipmentTypeDTO equipmentTypeDTO = equipmentTypeService.findById(id);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(equipmentTypeDTO, trackId), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateEquipmentType(@RequestParam(required = true) String id,
			@RequestBody(required = true) EquipmentTypeUpdateDTO equipmentTypeUpdateDTO,
			@RequestParam(required = true) String trackId) throws Exception {		
		equipmentTypeUpdateDTO = equipmentTypeService.update(equipmentTypeUpdateDTO);		
		return new ResponseEntity<>(ResponseHelper.constructResponse(equipmentTypeUpdateDTO, trackId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteEquipmentType(@PathVariable String id,
			@RequestParam(required = true) String trackId) throws Exception {
		equipmentTypeService.delete(id);		
		return new ResponseEntity<>(ResponseHelper.getDefaultResponse(trackId), HttpStatus.OK);
	}

}
