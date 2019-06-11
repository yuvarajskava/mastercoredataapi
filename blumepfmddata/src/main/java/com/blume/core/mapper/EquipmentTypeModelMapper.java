package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.EquipmentTypeDTO;
import com.blume.core.dto.EquipmentTypeUpdateDTO;
import com.blume.core.model.EquipmentType;

@Mapper(imports = System.class)
public interface EquipmentTypeModelMapper {

	EquipmentTypeDTO entityToDto(EquipmentType equipment);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	EquipmentType dtoToEntity(EquipmentTypeDTO equipmentDto);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	EquipmentType updatedtoToEntity(EquipmentTypeUpdateDTO equipmentUpdateDto);

	EquipmentTypeUpdateDTO entityToUpdateDTO(EquipmentType equipmentupdate);

	@IterableMapping(elementTargetType = EquipmentTypeDTO.class)
	List<EquipmentTypeDTO> entityListToDtoList(List<EquipmentType> equipmentList);	
	
	@IterableMapping(elementTargetType = EquipmentType.class)
	List<EquipmentType> dtoListToEntityList(List<EquipmentTypeDTO> equipmentTypeDTO);

}
