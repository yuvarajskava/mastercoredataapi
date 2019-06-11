package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.EquipmentTypeProcessImpl;
import com.blume.core.dto.EquipmentTypeDTO;
import com.blume.core.dto.EquipmentTypeUpdateDTO;
import com.blume.core.mapper.EquipmentTypeModelMapper;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.model.EquipmentType;
import com.blume.core.service.EquipmentTypeService;

@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(EquipmentTypeServiceImpl.class);
	
	
	@Autowired
	private EquipmentTypeProcessImpl equipmentTypeProcessImpl;

	public List<EquipmentTypeDTO> create(List<EquipmentTypeDTO> equipmentTypeDTOList) {
		
		try {
			equipmentTypeDTOList =  MapperUtil.getModelMapper(EquipmentTypeModelMapper.class)
					.entityListToDtoList(equipmentTypeProcessImpl.create(equipmentTypeDTOList));
			
		}
		catch(Exception e)
		{		
			logger.error("EquipmentType create {}",e);
			throw e;
		}
		
		return equipmentTypeDTOList;
	}

	@Override
	public List<EquipmentTypeDTO> findAllList() {
		
		List<EquipmentTypeDTO> equipmentTypelist = null;
			try {
				equipmentTypelist = MapperUtil.getModelMapper(EquipmentTypeModelMapper.class)
						.entityListToDtoList(equipmentTypeProcessImpl.getAllEquimentListType());
				
		}
		catch(Exception e)
		{			
			logger.error("EquipmentType findAllList {}",e);
			throw e;
		}
		
		return  equipmentTypelist;
	}

	@Override
	public EquipmentTypeUpdateDTO update(EquipmentTypeUpdateDTO equipmentTypeUpdateDTO) {
		try {
			equipmentTypeUpdateDTO = MapperUtil.getModelMapper(EquipmentTypeModelMapper.class)
					.entityToUpdateDTO(equipmentTypeProcessImpl.update(equipmentTypeUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("EquipmentType update {}",e);
			throw e;
		}
		
		return  equipmentTypeUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			equipmentTypeProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("EquipmentType create {}",e);
			throw e;
		}
	}

	@Override
	public EquipmentTypeDTO findById(String id) {
		Optional<EquipmentType> equipmentType = null;
		EquipmentTypeDTO equipmentTypeDTO = null;		
		try {
			
			equipmentType =  equipmentTypeProcessImpl.findById(id);
			
			if(equipmentType.isPresent())
			{
				equipmentTypeDTO =  MapperUtil.getModelMapper(EquipmentTypeModelMapper.class)
						.entityToDto(equipmentType.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("EquipmentType create {}",e);
			throw e;
		}
		
		return equipmentTypeDTO;
	}
}
