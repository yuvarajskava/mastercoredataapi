package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformUOMDTO;
import com.blume.core.dto.PlatformUOMUpdateDTO;
import com.blume.core.model.PlatformUOM;

@Mapper(imports = System.class)
public interface PlatformUOMModelMapper {

	PlatformUOMDTO entityToDto(PlatformUOM platformUOM);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformUOM dtoToEntity(PlatformUOMDTO platformUOMDto);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformUOM updatedtoToEntity(PlatformUOMUpdateDTO platformUOMUpdateDto);

	PlatformUOMUpdateDTO entityToUpdateDTO(PlatformUOM platformUOMUpdate);

	@IterableMapping(elementTargetType = PlatformUOMDTO.class)
	List<PlatformUOMDTO> entityListToDtoList(List<PlatformUOM> platformUOMList);

	@IterableMapping(elementTargetType = PlatformUOM.class)
	List<PlatformUOM> dtoListToEntityList(List<PlatformUOMDTO> platformUOMDTOList);


}
