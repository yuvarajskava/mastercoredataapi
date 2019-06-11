package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.EquipmentTypeProcess;
import com.blume.core.dto.EquipmentTypeDTO;
import com.blume.core.dto.EquipmentTypeUpdateDTO;
import com.blume.core.mapper.EquipmentTypeModelMapper;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.model.EquipmentType;
import com.blume.core.repository.EquipmentTypeRepository;

@Service
public class EquipmentTypeProcessImpl implements EquipmentTypeProcess {	

	@Autowired
	private EquipmentTypeRepository equipmentTypeRepository;

	public List<EquipmentType> getAllEquimentListType() {
		return equipmentTypeRepository.findAll();
	}

	public List<EquipmentType> create(List<EquipmentTypeDTO> equipmentTypeDTOList) {
		List<EquipmentType> equipmentTypeList = MapperUtil.getModelMapper(EquipmentTypeModelMapper.class).dtoListToEntityList(equipmentTypeDTOList);		
		equipmentTypeList = equipmentTypeRepository.saveAll(equipmentTypeList);
		return equipmentTypeList;
	}

	public EquipmentType update(EquipmentTypeUpdateDTO equipmentTypeUpdateDTO) {
		EquipmentType equipmentType = null;

		equipmentType = MapperUtil.getModelMapper(EquipmentTypeModelMapper.class)
				.updatedtoToEntity(equipmentTypeUpdateDTO);
		long currentTime = System.currentTimeMillis();
		equipmentType.setUpdatedTimeStamp(currentTime);		

		Optional<EquipmentType> equipmentTypeupdate = equipmentTypeRepository.findById(equipmentType.getId());
		if(equipmentTypeupdate.isPresent())
		{
			equipmentType.setCreatedBy(equipmentTypeupdate.get().getCreatedBy());
			equipmentType.setCreatedTimeStamp(equipmentTypeupdate.get().getCreatedTimeStamp());
		}
		return equipmentTypeRepository.save(equipmentType);

	}

	public void delete(String id) {

		equipmentTypeRepository.deleteById(id);
	}

	public Optional<EquipmentType> findById(String id) {	

		return equipmentTypeRepository.findById(id);

	}
	
}
