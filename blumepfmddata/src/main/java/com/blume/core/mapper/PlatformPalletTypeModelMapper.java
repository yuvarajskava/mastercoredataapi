package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.PlatformPalletTypeDTO;
import com.blume.core.dto.PlatformPalletTypeUpdateDTO;
import com.blume.core.model.PlatformPalletType;

@Mapper(imports = System.class)
public interface PlatformPalletTypeModelMapper {

	PlatformPalletTypeDTO entityToDto(PlatformPalletType platformPalletType);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformPalletType dtoToEntity(PlatformPalletTypeDTO platformPalletTypeDto);
	
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	PlatformPalletType updatedtoToEntity(PlatformPalletTypeUpdateDTO platformPalletTypeUpdateDto);

	PlatformPalletTypeUpdateDTO entityToUpdateDTO(PlatformPalletType platformPalletTypeUpdate);

	@IterableMapping(elementTargetType = PlatformPalletTypeDTO.class)
	List<PlatformPalletTypeDTO> entityListToDtoList(List<PlatformPalletType> platformPalletTypeList);

	@IterableMapping(elementTargetType = PlatformPalletType.class)
	List<PlatformPalletType> dtoListToEntityList(List<PlatformPalletTypeDTO> platformPalletTypeDTOList);


}
