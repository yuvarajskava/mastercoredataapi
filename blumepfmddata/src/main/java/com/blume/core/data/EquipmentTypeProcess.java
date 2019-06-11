package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.EquipmentTypeDTO;
import com.blume.core.dto.EquipmentTypeUpdateDTO;
import com.blume.core.model.EquipmentType;

public interface EquipmentTypeProcess {

	public List<EquipmentType> create(List<EquipmentTypeDTO> equipmentTypeDTO);

	List<EquipmentType> getAllEquimentListType();

	public EquipmentType update(EquipmentTypeUpdateDTO equipmentTypeUpdateDTO);

	public void delete(String id);
	
	public Optional<EquipmentType> findById(String id);

}
