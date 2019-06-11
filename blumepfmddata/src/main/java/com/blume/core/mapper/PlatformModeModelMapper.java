package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformModeDTO;
import com.blume.core.dto.PlatformModeUpdateDTO;
import com.blume.core.model.PlatformMode;

@Mapper(imports = System.class)
public interface PlatformModeModelMapper {

	PlatformModeDTO entityToDto(PlatformMode platformMode);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformMode dtoToEntity(PlatformModeDTO platformModeDto);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformMode updatedtoToEntity(PlatformModeUpdateDTO platformModeUpdateDto);

	PlatformModeUpdateDTO entityToUpdateDTO(PlatformMode platformModeUpdate);

	@IterableMapping(elementTargetType = PlatformModeDTO.class)
	List<PlatformModeDTO> entityListToDtoList(List<PlatformMode> platformModeList);

	@IterableMapping(elementTargetType = PlatformMode.class)
	List<PlatformMode> dtoListToEntityList(List<PlatformModeDTO> platformModeDTOList);

}
