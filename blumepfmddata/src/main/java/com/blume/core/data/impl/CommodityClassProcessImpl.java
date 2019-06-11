package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.CommodityClassProcess;
import com.blume.core.dto.CommodityClassDTO;
import com.blume.core.dto.CommodityClassUpdateDTO;
import com.blume.core.mapper.CommodityClassModelMapper;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.model.CommodityClass;
import com.blume.core.repository.CommodityClassRepository;


@Service
public class CommodityClassProcessImpl implements CommodityClassProcess  {
	
	@Autowired
	private CommodityClassRepository commodityClassRepository;

	public List<CommodityClass> getAllCommodity() {
		return commodityClassRepository.findAll();
	}

	public List<CommodityClass> create(List<CommodityClassDTO> commodityClassDTO) {			
		List<CommodityClass> commodityClassList= MapperUtil.getModelMapper(CommodityClassModelMapper.class).dtoListToEntityList(commodityClassDTO);
				
		commodityClassList = commodityClassRepository.saveAll(commodityClassList);
		return commodityClassList; 
	}

	public CommodityClass update(CommodityClassUpdateDTO commodityClassUpdateDTO) {
		CommodityClass commodityClass = null;

		commodityClass = MapperUtil.getModelMapper(CommodityClassModelMapper.class)
				.updatedtoToEntity(commodityClassUpdateDTO);
		long currentTime = System.currentTimeMillis();
		commodityClass.setUpdatedTimeStamp(currentTime);

		Optional<CommodityClass> commodityClassUdate = commodityClassRepository.findById(commodityClass.getId());	
		if(commodityClassUdate.isPresent())
		{
			commodityClass.setCreatedBy(commodityClassUdate.get().getCreatedBy());
			commodityClass.setCreatedTimeStamp(commodityClassUdate.get().getCreatedTimeStamp());
		}

		return commodityClassRepository.save(commodityClass);

	}

	public void delete(String id) {

		commodityClassRepository.deleteById(id);
	}

	public Optional<CommodityClass> viewById(String id) {
		
		return commodityClassRepository.findById(id);

	}
	

}
