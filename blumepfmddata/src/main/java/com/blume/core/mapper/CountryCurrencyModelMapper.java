package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.CountryCurrencyDTO;
import com.blume.core.dto.CountryCurrencyUpdateDTO;
import com.blume.core.model.CountryCurrency;

@Mapper(imports = System.class)
public interface CountryCurrencyModelMapper {

	CountryCurrencyDTO entityToDto(CountryCurrency countryCurrency);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	CountryCurrency dtoToEntity(CountryCurrencyDTO countryCurrencyDTO);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	CountryCurrency updatedtoToEntity(CountryCurrencyUpdateDTO countryCurrencyUpdateDTO);

	CountryCurrencyUpdateDTO entityToUpdateDTO(CountryCurrency countryCurrency);

	@IterableMapping(elementTargetType = CountryCurrencyDTO.class)
	List<CountryCurrencyDTO> entityListToDtoList(List<CountryCurrency> countryCurrencyList);
	
	@IterableMapping(elementTargetType = CountryCurrency.class)
	List<CountryCurrency> dtoListToEntityList(List<CountryCurrencyDTO> countryCurrency);

}
