package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.PlatformRateBasisProcessImpl;
import com.blume.core.dto.PlatformRateBasisDTO;
import com.blume.core.dto.PlatformRateBasisUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformRateBasisModelMapper;
import com.blume.core.model.PlatformRateBasis;
import com.blume.core.service.PlatformRateBasisService;


@Service
public class PlatformRateBasisServiceImpl implements PlatformRateBasisService {
	
	private static Logger logger = LoggerFactory.getLogger(PlatformRateBasisServiceImpl.class);
	
	@Autowired
	private PlatformRateBasisProcessImpl platformRateBasisProcessImpl;

	public List<PlatformRateBasisDTO> create(List<PlatformRateBasisDTO> platformRateBasisDTOList) {
		
		try {
			platformRateBasisDTOList =  MapperUtil.getModelMapper(PlatformRateBasisModelMapper.class)
					.entityListToDtoList(platformRateBasisProcessImpl.create(platformRateBasisDTOList));			
		}
		catch(Exception e)
		{			
			logger.error("PlatformRateBasis create {}",e);
			throw e;
		}
		
		return platformRateBasisDTOList;
	}

	@Override
	public List<PlatformRateBasisDTO> findAllList() {
		
		List<PlatformRateBasisDTO> platformRateBasislist = null;
			try {
				platformRateBasislist = MapperUtil.getModelMapper(PlatformRateBasisModelMapper.class)
						.entityListToDtoList(platformRateBasisProcessImpl.findAllList());				 
		}
		catch(Exception e)
		{			
			logger.error("PlatformRateBasis findAllList {}",e);
			throw e;
		}
		
		return  platformRateBasislist;
	}

	@Override
	public PlatformRateBasisUpdateDTO update(PlatformRateBasisUpdateDTO platformRateBasisUpdateDTO) {
		try {
			platformRateBasisUpdateDTO = MapperUtil.getModelMapper(PlatformRateBasisModelMapper.class)
					.entityToUpdateDTO(platformRateBasisProcessImpl.update(platformRateBasisUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("PlatformRateBasis update {}",e);
			throw e;
		}		
		return  platformRateBasisUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			platformRateBasisProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("PlatformRateBasis create {}",e);
			throw e;
		}
	}

	@Override
	public PlatformRateBasisDTO findById(String id) {
		Optional<PlatformRateBasis> platformRateBasis = null;
		PlatformRateBasisDTO platformRateBasisDTO = null;		
		try {			
			platformRateBasis = platformRateBasisProcessImpl.viewById(id);	
			
			if(platformRateBasis.isPresent())
			{
				platformRateBasisDTO =  MapperUtil.getModelMapper(PlatformRateBasisModelMapper.class)
						.entityToDto(platformRateBasis.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("PlatformRateBasis create {}",e);
			throw e;
		}		
		return platformRateBasisDTO;
	}

}
