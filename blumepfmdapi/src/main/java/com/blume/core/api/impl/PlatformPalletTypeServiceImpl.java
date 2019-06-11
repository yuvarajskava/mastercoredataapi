package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformPalletTypeProcessImpl;
import com.blume.core.dto.PlatformPalletTypeDTO;
import com.blume.core.dto.PlatformPalletTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformPalletTypeModelMapper;
import com.blume.core.model.PlatformPalletType;
import com.blume.core.service.PlatformPalletTypeService;


@Service
public class PlatformPalletTypeServiceImpl implements PlatformPalletTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformPalletTypeServiceImpl.class);
	
	@Autowired
	private PlatformPalletTypeProcessImpl platformPalletTypeProcessImpl;

	public List<PlatformPalletTypeDTO> create(List<PlatformPalletTypeDTO> platformPalletTypeDTOList) {
		
		try {
			platformPalletTypeDTOList =  MapperUtil.getModelMapper(PlatformPalletTypeModelMapper.class)
					.entityListToDtoList(platformPalletTypeProcessImpl.create(platformPalletTypeDTOList));
			
		}
		catch(Exception e)
		{			
			logger.error("PlatformPalletType create {}",e);
			throw e;
		}
		
		return platformPalletTypeDTOList;
	}

	@Override
	public List<PlatformPalletTypeDTO> findAllList() {
		
		List<PlatformPalletTypeDTO> platformPalletTypelist = null;
			try {
				platformPalletTypelist = MapperUtil.getModelMapper(PlatformPalletTypeModelMapper.class)
						.entityListToDtoList(platformPalletTypeProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformPalletType findAllList {}",e);
			throw e;
		}
		
		return  platformPalletTypelist;
	}

	@Override
	public PlatformPalletTypeUpdateDTO update(PlatformPalletTypeUpdateDTO platformPalletTypeUpdateDTO) {
		try {
			platformPalletTypeUpdateDTO = MapperUtil.getModelMapper(PlatformPalletTypeModelMapper.class)
					.entityToUpdateDTO(platformPalletTypeProcessImpl.update(platformPalletTypeUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformPalletType update {}",e);
			throw e;
		}		
		return  platformPalletTypeUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformPalletTypeProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformPalletType create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformPalletTypeDTO findById(String id) {
		Optional<PlatformPalletType> platformPalletType = null;
		PlatformPalletTypeDTO platformPalletTypeDTO = null;		
		try {			
			platformPalletType = platformPalletTypeProcessImpl.viewById(id);	
			
			if(platformPalletType.isPresent())
			{
				platformPalletTypeDTO =  MapperUtil.getModelMapper(PlatformPalletTypeModelMapper.class)
						.entityToDto(platformPalletType.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformPalletType create {}",e);
			throw e;
		}		
		return platformPalletTypeDTO;
	}

}
