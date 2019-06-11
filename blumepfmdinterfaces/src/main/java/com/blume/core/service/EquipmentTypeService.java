package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.EquipmentTypeDTO;
import com.blume.core.dto.EquipmentTypeUpdateDTO;

public interface EquipmentTypeService {

	public List<EquipmentTypeDTO> create(List<EquipmentTypeDTO> equipmentTypeDTO);

	public List<EquipmentTypeDTO> findAllList();

	public EquipmentTypeUpdateDTO update(EquipmentTypeUpdateDTO equipmentTypeUpdateDTO);

	public void delete(String id);
	
	public EquipmentTypeDTO findById(String id);

}
