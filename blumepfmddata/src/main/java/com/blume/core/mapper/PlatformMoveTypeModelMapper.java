package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformMoveTypeDTO;
import com.blume.core.dto.PlatformMoveTypeUpdateDTO;
import com.blume.core.model.PlatformMoveType;

@Mapper(imports = System.class)
public interface PlatformMoveTypeModelMapper {

	PlatformMoveTypeDTO entityToDto(PlatformMoveType platformMoveType);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformMoveType dtoToEntity(PlatformMoveTypeDTO platformMoveTypeDto);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformMoveType updatedtoToEntity(PlatformMoveTypeUpdateDTO platformMoveTypeUpdateDto);

	PlatformMoveTypeUpdateDTO entityToUpdateDTO(PlatformMoveType platformMoveTypeUpdate);

	@IterableMapping(elementTargetType = PlatformMoveTypeDTO.class)
	List<PlatformMoveTypeDTO> entityListToDtoList(List<PlatformMoveType> platformMoveTypeList);

	@IterableMapping(elementTargetType = PlatformMoveType.class)
	List<PlatformMoveType> dtoListToEntityList(List<PlatformMoveTypeDTO> platformMoveTypeDTOList);

}
