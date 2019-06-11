package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformTripTypeDTO;
import com.blume.core.dto.PlatformTripTypeUpdateDTO;
import com.blume.core.model.PlatformTripType;

@Mapper(imports = System.class)
public interface PlatformTripTypeModelMapper {

	PlatformTripTypeDTO entityToDto(PlatformTripType platformTripType);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformTripType dtoToEntity(PlatformTripTypeDTO platformTripTypeDto);

	
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformTripType updatedtoToEntity(PlatformTripTypeUpdateDTO platformTripTypeUpdateDto);

	PlatformTripTypeUpdateDTO entityToUpdateDTO(PlatformTripType platformTripTypeUpdate);

	@IterableMapping(elementTargetType = PlatformTripTypeDTO.class)
	List<PlatformTripTypeDTO> entityListToDtoList(List<PlatformTripType> platformTripTypeList);

	@IterableMapping(elementTargetType = PlatformTripType.class)
	List<PlatformTripType> dtoListToEntityList(List<PlatformTripTypeDTO> platformTripTypeDTOList);

}
