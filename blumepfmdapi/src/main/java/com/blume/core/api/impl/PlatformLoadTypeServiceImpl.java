package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformLoadTypeProcessImpl;
import com.blume.core.dto.PlatformLoadTypeDTO;
import com.blume.core.dto.PlatformLoadTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformLoadTypeModelMapper;
import com.blume.core.model.PlatformLoadType;
import com.blume.core.service.PlatformLoadTypeService;


@Service
public class PlatformLoadTypeServiceImpl implements PlatformLoadTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformLoadTypeServiceImpl.class);
	
	@Autowired
	private PlatformLoadTypeProcessImpl platformLoadTypeProcessImpl;

	public List<PlatformLoadTypeDTO> create(List<PlatformLoadTypeDTO> platformLoadTypeDTOList) {
		
		try {
			platformLoadTypeDTOList =  MapperUtil.getModelMapper(PlatformLoadTypeModelMapper.class)
					.entityListToDtoList(platformLoadTypeProcessImpl.create(platformLoadTypeDTOList));
			
		}
		catch(Exception e)
		{			
			logger.error("PlatformLoadType create {}",e);
			throw e;
		}
		
		return platformLoadTypeDTOList;
	}

	@Override
	public List<PlatformLoadTypeDTO> findAllList() {
		
		List<PlatformLoadTypeDTO> platformLoadTypelist = null;
			try {
				platformLoadTypelist = MapperUtil.getModelMapper(PlatformLoadTypeModelMapper.class)
						.entityListToDtoList(platformLoadTypeProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformLoadType findAllList {}",e);
			throw e;
		}
		
		return  platformLoadTypelist;
	}

	@Override
	public PlatformLoadTypeUpdateDTO update(PlatformLoadTypeUpdateDTO platformLoadTypeUpdateDTO) {
		try {
			platformLoadTypeUpdateDTO = MapperUtil.getModelMapper(PlatformLoadTypeModelMapper.class)
					.entityToUpdateDTO(platformLoadTypeProcessImpl.update(platformLoadTypeUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformLoadType update {}",e);
			throw e;
		}		
		return  platformLoadTypeUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformLoadTypeProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformLoadType create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformLoadTypeDTO findById(String id) {
		Optional<PlatformLoadType> platformLoadType = null;
		PlatformLoadTypeDTO platformLoadTypeDTO = null;		
		try {			
			platformLoadType = platformLoadTypeProcessImpl.viewById(id);	
			
			if(platformLoadType.isPresent())
			{
				platformLoadTypeDTO =  MapperUtil.getModelMapper(PlatformLoadTypeModelMapper.class)
						.entityToDto(platformLoadType.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformLoadType create {}",e);
			throw e;
		}		
		return platformLoadTypeDTO;
	}

}
