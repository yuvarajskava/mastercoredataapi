package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformServiceLevelProcessImpl;
import com.blume.core.dto.PlatformServiceLevelDTO;
import com.blume.core.dto.PlatformServiceLevelUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformServiceLevelModelMapper;
import com.blume.core.model.PlatformServiceLevel;
import com.blume.core.service.PlatformServiceLevelService;


@Service
public class PlatformServiceLevelServiceImpl implements PlatformServiceLevelService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformServiceLevelServiceImpl.class);
	
	@Autowired
	private PlatformServiceLevelProcessImpl platformServiceLevelProcessImpl;

	public List<PlatformServiceLevelDTO> create(List<PlatformServiceLevelDTO> platformServiceLevelDTOList) {
		
		try {
			platformServiceLevelDTOList =  MapperUtil.getModelMapper(PlatformServiceLevelModelMapper.class)
					.entityListToDtoList(platformServiceLevelProcessImpl.create(platformServiceLevelDTOList));			
		}
		catch(Exception e)
		{			
			logger.error("PlatformServiceLevel create {}",e);
			throw e;
		}
		
		return platformServiceLevelDTOList;
	}

	@Override
	public List<PlatformServiceLevelDTO> findAllList() {
		
		List<PlatformServiceLevelDTO> platformServiceLevellist = null;
			try {
				platformServiceLevellist = MapperUtil.getModelMapper(PlatformServiceLevelModelMapper.class)
						.entityListToDtoList(platformServiceLevelProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformServiceLevel findAllList {}",e);
			throw e;
		}
		
		return  platformServiceLevellist;
	}

	@Override
	public PlatformServiceLevelUpdateDTO update(PlatformServiceLevelUpdateDTO platformServiceLevelUpdateDTO) {
		try {
			platformServiceLevelUpdateDTO = MapperUtil.getModelMapper(PlatformServiceLevelModelMapper.class)
					.entityToUpdateDTO(platformServiceLevelProcessImpl.update(platformServiceLevelUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformServiceLevel update {}",e);
			throw e;
		}		
		return  platformServiceLevelUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformServiceLevelProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformServiceLevel create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformServiceLevelDTO findById(String id) {
		Optional<PlatformServiceLevel> platformServiceLevel = null;
		PlatformServiceLevelDTO platformServiceLevelDTO = null;		
		try {			
			platformServiceLevel = platformServiceLevelProcessImpl.viewById(id);	
			
			if(platformServiceLevel.isPresent())
			{
				platformServiceLevelDTO =  MapperUtil.getModelMapper(PlatformServiceLevelModelMapper.class)
						.entityToDto(platformServiceLevel.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformServiceLevel create {}",e);
			throw e;
		}		
		return platformServiceLevelDTO;
	}

}
