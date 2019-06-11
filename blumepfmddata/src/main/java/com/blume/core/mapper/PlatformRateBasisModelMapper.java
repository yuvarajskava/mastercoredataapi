package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformRateBasisDTO;
import com.blume.core.dto.PlatformRateBasisUpdateDTO;
import com.blume.core.model.PlatformRateBasis;

@Mapper(imports = System.class)
public interface PlatformRateBasisModelMapper {

	PlatformRateBasisDTO entityToDto(PlatformRateBasis platformRateBasis);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformRateBasis dtoToEntity(PlatformRateBasisDTO platformRateBasisDto);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformRateBasis updatedtoToEntity(PlatformRateBasisUpdateDTO platformRateBasisUpdateDto);

	PlatformRateBasisUpdateDTO entityToUpdateDTO(PlatformRateBasis platformRateBasisUpdate);

	@IterableMapping(elementTargetType = PlatformRateBasisDTO.class)
	List<PlatformRateBasisDTO> entityListToDtoList(List<PlatformRateBasis> platformRateBasisList);

	@IterableMapping(elementTargetType = PlatformRateBasis.class)
	List<PlatformRateBasis> dtoListToEntityList(List<PlatformRateBasisDTO> platformRateBasisDTOList);

}
