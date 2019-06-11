package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformTripTypeProcessImpl;
import com.blume.core.dto.PlatformTripTypeDTO;
import com.blume.core.dto.PlatformTripTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformTripTypeModelMapper;
import com.blume.core.model.PlatformTripType;
import com.blume.core.service.PlatformTripTypeService;


@Service
public class PlatformTripTypeServiceImpl implements PlatformTripTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformTripTypeServiceImpl.class);
	
	@Autowired
	private PlatformTripTypeProcessImpl platformTripTypeProcessImpl;

	public List<PlatformTripTypeDTO> create(List<PlatformTripTypeDTO> platformTripTypeDTOList) {
		
		try {
			platformTripTypeDTOList =  MapperUtil.getModelMapper(PlatformTripTypeModelMapper.class)
					.entityListToDtoList(platformTripTypeProcessImpl.create(platformTripTypeDTOList));			
		}
		catch(Exception e)
		{			
			logger.error("PlatformTripType create {}",e);
			throw e;
		}
		
		return platformTripTypeDTOList;
	}

	@Override
	public List<PlatformTripTypeDTO> findAllList() {
		
		List<PlatformTripTypeDTO> platformTripTypelist = null;
			try {
				platformTripTypelist = MapperUtil.getModelMapper(PlatformTripTypeModelMapper.class)
						.entityListToDtoList(platformTripTypeProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformTripType findAllList {}",e);
			throw e;
		}
		
		return  platformTripTypelist;
	}

	@Override
	public PlatformTripTypeUpdateDTO update(PlatformTripTypeUpdateDTO platformTripTypeUpdateDTO) {
		try {
			platformTripTypeUpdateDTO = MapperUtil.getModelMapper(PlatformTripTypeModelMapper.class)
					.entityToUpdateDTO(platformTripTypeProcessImpl.update(platformTripTypeUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformTripType update {}",e);
			throw e;
		}		
		return  platformTripTypeUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformTripTypeProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformTripType create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformTripTypeDTO findById(String id) {
		Optional<PlatformTripType> platformTripType = null;
		PlatformTripTypeDTO platformTripTypeDTO = null;		
		try {			
			platformTripType = platformTripTypeProcessImpl.viewById(id);	
			
			if(platformTripType.isPresent())
			{
				platformTripTypeDTO =  MapperUtil.getModelMapper(PlatformTripTypeModelMapper.class)
						.entityToDto(platformTripType.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformTripType create {}",e);
			throw e;
		}		
		return platformTripTypeDTO;
	}

}
