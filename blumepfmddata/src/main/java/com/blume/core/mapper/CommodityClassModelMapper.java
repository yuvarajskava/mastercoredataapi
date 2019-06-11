package com.blume.core.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.blume.core.dto.CommodityClassDTO;
import com.blume.core.dto.CommodityClassUpdateDTO;
import com.blume.core.model.CommodityClass;

@Mapper(imports = System.class)
public interface CommodityClassModelMapper {

	CommodityClassDTO entityToDto(CommodityClass commodityClass);

	@Mapping(target="createdTimeStamp",expression="java(System.currentTimeMillis())")
	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	CommodityClass dtoToEntity(CommodityClassDTO commodityDto);

	@Mapping(target="updatedTimeStamp",expression="java(System.currentTimeMillis())")
	CommodityClass updatedtoToEntity(CommodityClassUpdateDTO commodityUpdateDto);

	CommodityClassUpdateDTO entityToUpdateDTO(CommodityClass commodityUpdate);

	@IterableMapping(elementTargetType = CommodityClassDTO.class)
	List<CommodityClassDTO> entityListToDtoList(List<CommodityClass> commodityList);
	
	@IterableMapping(elementTargetType = CommodityClass.class)
	List<CommodityClass> dtoListToEntityList(List<CommodityClassDTO> commodityClassDTO);


}
