package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformLoadTypeDTO;
import com.blume.core.dto.PlatformLoadTypeUpdateDTO;
import com.blume.core.model.PlatformLoadType;

@Mapper(imports = System.class)
public interface PlatformLoadTypeModelMapper {

	PlatformLoadTypeDTO entityToDto(PlatformLoadType platformLoadType);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformLoadType dtoToEntity(PlatformLoadTypeDTO platformLoadTypeDto);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformLoadType updatedtoToEntity(PlatformLoadTypeUpdateDTO platformLoadTypeUpdateDto);

	PlatformLoadTypeUpdateDTO entityToUpdateDTO(PlatformLoadType platformLoadTypeUpdate);

	@IterableMapping(elementTargetType = PlatformLoadTypeDTO.class)
	List<PlatformLoadTypeDTO> entityListToDtoList(List<PlatformLoadType> platformLoadTypeList);

	@IterableMapping(elementTargetType = PlatformLoadType.class)
	List<PlatformLoadType> dtoListToEntityList(List<PlatformLoadTypeDTO> platformLoadTypeList);

}
