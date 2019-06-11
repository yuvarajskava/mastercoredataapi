package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformModeProcessImpl;
import com.blume.core.dto.PlatformModeDTO;
import com.blume.core.dto.PlatformModeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformModeModelMapper;
import com.blume.core.model.PlatformMode;
import com.blume.core.service.PlatformModeService;


@Service
public class PlatformModeServiceImpl implements PlatformModeService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformModeServiceImpl.class);
	
	@Autowired
	private PlatformModeProcessImpl platformModeProcessImpl;

	public List<PlatformModeDTO> create(List<PlatformModeDTO> platformModeDTOList) {
		
		try {
			platformModeDTOList =  MapperUtil.getModelMapper(PlatformModeModelMapper.class)
					.entityListToDtoList(platformModeProcessImpl.create(platformModeDTOList));
			
		}
		catch(Exception e)
		{			
			logger.error("PlatformMode create {}",e);
			throw e;
		}
		
		return platformModeDTOList;
	}

	@Override
	public List<PlatformModeDTO> findAllList() {
		
		List<PlatformModeDTO> platformModelist = null;
			try {
				platformModelist = MapperUtil.getModelMapper(PlatformModeModelMapper.class)
						.entityListToDtoList(platformModeProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformMode findAllList {}",e);
			throw e;
		}
		
		return  platformModelist;
	}

	@Override
	public PlatformModeUpdateDTO update(PlatformModeUpdateDTO platformModeUpdateDTO) {
		try {
			platformModeUpdateDTO = MapperUtil.getModelMapper(PlatformModeModelMapper.class)
					.entityToUpdateDTO(platformModeProcessImpl.update(platformModeUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformMode update {}",e);
			throw e;
		}		
		return  platformModeUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformModeProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformMode create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformModeDTO findById(String id) {
		Optional<PlatformMode> platformMode = null;
		PlatformModeDTO platformModeDTO = null;		
		try {			
			platformMode = platformModeProcessImpl.viewById(id);	
			
			if(platformMode.isPresent())
			{
				platformModeDTO =  MapperUtil.getModelMapper(PlatformModeModelMapper.class)
						.entityToDto(platformMode.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformMode create {}",e);
			throw e;
		}		
		return platformModeDTO;
	}

}
