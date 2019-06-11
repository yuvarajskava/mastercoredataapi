package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.CommodityClassProcess;
import com.blume.core.dto.CommodityClassDTO;
import com.blume.core.dto.CommodityClassUpdateDTO;
import com.blume.core.mapper.CommodityClassModelMapper;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.model.CommodityClass;
import com.blume.core.service.CommodityClassService;




@Service
public class CommodityClassServiceImpl implements CommodityClassService {
	
	private static Logger logger = LoggerFactory.getLogger(CommodityClassServiceImpl.class);
	
	@Autowired
	private CommodityClassProcess commodityClassProcess;

	public List<CommodityClassDTO> create(List<CommodityClassDTO> commodityClassDTO) {
		
		try {
			commodityClassDTO =  MapperUtil.getModelMapper(CommodityClassModelMapper.class)
					.entityListToDtoList(commodityClassProcess.create(commodityClassDTO));
			
		}
		catch(Exception e)
		{			
			logger.error("CommodityClass create {}",e);
			throw e;
		}
		
		return commodityClassDTO;
	}

	@Override
	public List<CommodityClassDTO> findAllList() {
		
		List<CommodityClassDTO> commodityClasslist = null;
			try {
				commodityClasslist = MapperUtil.getModelMapper(CommodityClassModelMapper.class)
						.entityListToDtoList(commodityClassProcess.getAllCommodity());			 
		}
		catch(Exception e)
		{			
			logger.error("CommodityClass findAllList {}",e);
			throw e;
		}
		
		return  commodityClasslist;
	}

	@Override
	public CommodityClassUpdateDTO update(CommodityClassUpdateDTO commodityClassUpdateDTO) {
		try {
			commodityClassUpdateDTO = MapperUtil.getModelMapper(CommodityClassModelMapper.class)
					.entityToUpdateDTO(commodityClassProcess.update(commodityClassUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("CommodityClass update {}",e);
			throw e;
		}
		
		return  commodityClassUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			commodityClassProcess.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("CommodityClass create {}",e);
			throw e;
		}
	}

	@Override
	public CommodityClassDTO findById(String id) {
		Optional<CommodityClass> commodityClass = null;
		CommodityClassDTO commodityClassDTO = null;		
		try {			
			commodityClass = commodityClassProcess.viewById(id);	
			
			if(commodityClass.isPresent())
			{
				commodityClassDTO =  MapperUtil.getModelMapper(CommodityClassModelMapper.class)
						.entityToDto(commodityClass.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("CommodityClass create {}",e);
			throw e;
		}		
		return commodityClassDTO;
	}	

}
