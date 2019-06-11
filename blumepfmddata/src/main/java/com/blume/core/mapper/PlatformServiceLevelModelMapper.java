package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformServiceLevelDTO;
import com.blume.core.dto.PlatformServiceLevelUpdateDTO;
import com.blume.core.model.PlatformServiceLevel;

@Mapper(imports = System.class)
public interface PlatformServiceLevelModelMapper {

	PlatformServiceLevelDTO entityToDto(PlatformServiceLevel platformServiceLevel);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformServiceLevel dtoToEntity(PlatformServiceLevelDTO platformServiceLevelDto);

	
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformServiceLevel updatedtoToEntity(PlatformServiceLevelUpdateDTO platformServiceLevelUpdateDto);

	PlatformServiceLevelUpdateDTO entityToUpdateDTO(PlatformServiceLevel platformServiceLevelUpdate);

	@IterableMapping(elementTargetType = PlatformServiceLevelDTO.class)
	List<PlatformServiceLevelDTO> entityListToDtoList(List<PlatformServiceLevel> platformServiceLevelList);

	@IterableMapping(elementTargetType = PlatformServiceLevel.class)
	List<PlatformServiceLevel> dtoListToEntityList(List<PlatformServiceLevelDTO> platformServiceLevelDTOList);

}
