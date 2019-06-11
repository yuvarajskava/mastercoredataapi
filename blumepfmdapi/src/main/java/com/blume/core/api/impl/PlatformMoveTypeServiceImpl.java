package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformMoveTypeProcessImpl;
import com.blume.core.dto.PlatformMoveTypeDTO;
import com.blume.core.dto.PlatformMoveTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformMoveTypeModelMapper;
import com.blume.core.model.PlatformMoveType;
import com.blume.core.service.PlatformMoveTypeService;


@Service
public class PlatformMoveTypeServiceImpl implements PlatformMoveTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformMoveTypeServiceImpl.class);
	
	@Autowired
	private PlatformMoveTypeProcessImpl platformMoveTypeProcessImpl;

	public List<PlatformMoveTypeDTO> create(List<PlatformMoveTypeDTO> platformMoveTypeDTOList) {
		
		try {
			platformMoveTypeDTOList =  MapperUtil.getModelMapper(PlatformMoveTypeModelMapper.class)
					.entityListToDtoList(platformMoveTypeProcessImpl.create(platformMoveTypeDTOList));
			
		}
		catch(Exception e)
		{			
			logger.error("PlatformMoveType create {}",e);
			throw e;
		}
		
		return platformMoveTypeDTOList;
	}

	@Override
	public List<PlatformMoveTypeDTO> findAllList() {
		
		List<PlatformMoveTypeDTO> platformMoveTypelist = null;
			try {
				platformMoveTypelist = MapperUtil.getModelMapper(PlatformMoveTypeModelMapper.class)
						.entityListToDtoList(platformMoveTypeProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformMoveType findAllList {}",e);
			throw e;
		}
		
		return  platformMoveTypelist;
	}

	@Override
	public PlatformMoveTypeUpdateDTO update(PlatformMoveTypeUpdateDTO platformMoveTypeUpdateDTO) {
		try {
			platformMoveTypeUpdateDTO = MapperUtil.getModelMapper(PlatformMoveTypeModelMapper.class)
					.entityToUpdateDTO(platformMoveTypeProcessImpl.update(platformMoveTypeUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformMoveType update {}",e);
			throw e;
		}		
		return  platformMoveTypeUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformMoveTypeProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformMoveType create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformMoveTypeDTO findById(String id) {
		Optional<PlatformMoveType> platformMoveType = null;
		PlatformMoveTypeDTO platformMoveTypeDTO = null;		
		try {			
			platformMoveType = platformMoveTypeProcessImpl.viewById(id);	
			
			if(platformMoveType.isPresent())
			{
				platformMoveTypeDTO =  MapperUtil.getModelMapper(PlatformMoveTypeModelMapper.class)
						.entityToDto(platformMoveType.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformMoveType create {}",e);
			throw e;
		}		
		return platformMoveTypeDTO;
	}

}
