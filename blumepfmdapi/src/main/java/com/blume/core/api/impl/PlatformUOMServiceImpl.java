package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformUOMProcessImpl;
import com.blume.core.dto.PlatformUOMDTO;
import com.blume.core.dto.PlatformUOMUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformUOMModelMapper;
import com.blume.core.model.PlatformUOM;
import com.blume.core.service.PlatformUOMService;


@Service
public class PlatformUOMServiceImpl implements PlatformUOMService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformUOMServiceImpl.class);
	
	@Autowired
	private PlatformUOMProcessImpl platformUOMProcessImpl;

	public List<PlatformUOMDTO> create(List<PlatformUOMDTO> platformUOMDTOList) {
		
		try {
			platformUOMDTOList =  MapperUtil.getModelMapper(PlatformUOMModelMapper.class)
					.entityListToDtoList(platformUOMProcessImpl.create(platformUOMDTOList));			
		}
		catch(Exception e)
		{			
			logger.error("PlatformUOM create {}",e);
			throw e;
		}
		
		return platformUOMDTOList;
	}

	@Override
	public List<PlatformUOMDTO> findAllList() {
		
		List<PlatformUOMDTO> platformUOMlist = null;
			try {
				platformUOMlist = MapperUtil.getModelMapper(PlatformUOMModelMapper.class)
						.entityListToDtoList(platformUOMProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformUOM findAllList {}",e);
			throw e;
		}
		
		return  platformUOMlist;
	}

	@Override
	public PlatformUOMUpdateDTO update(PlatformUOMUpdateDTO platformUOMUpdateDTO) {
		try {
			platformUOMUpdateDTO = MapperUtil.getModelMapper(PlatformUOMModelMapper.class)
					.entityToUpdateDTO(platformUOMProcessImpl.update(platformUOMUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformUOM update {}",e);
			throw e;
		}		
		return  platformUOMUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformUOMProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformUOM create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformUOMDTO findById(String id) {
		Optional<PlatformUOM> platformUOM = null;
		PlatformUOMDTO platformUOMDTO = null;		
		try {			
			platformUOM = platformUOMProcessImpl.viewById(id);	
			
			if(platformUOM.isPresent())
			{
				platformUOMDTO =  MapperUtil.getModelMapper(PlatformUOMModelMapper.class)
						.entityToDto(platformUOM.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformUOM create {}",e);
			throw e;
		}		
		return platformUOMDTO;
	}

}
