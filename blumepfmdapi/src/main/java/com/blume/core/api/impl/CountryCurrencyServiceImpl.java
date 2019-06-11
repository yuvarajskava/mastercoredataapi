package com.blume.core.api.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.impl.CountryCurrencyProcessImpl;
import com.blume.core.dto.CountryCurrencyDTO;
import com.blume.core.dto.CountryCurrencyUpdateDTO;
import com.blume.core.mapper.CountryCurrencyModelMapper;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.model.CountryCurrency;
import com.blume.core.service.CountryCurrencyService;


@Service
public class CountryCurrencyServiceImpl implements CountryCurrencyService {
	
	private static Logger logger = LoggerFactory.getLogger(CountryCurrencyServiceImpl.class);
	
	@Autowired
	private CountryCurrencyProcessImpl countryCurrencyProcessImpl;

	public List<CountryCurrencyDTO> create(List<CountryCurrencyDTO> countryCurrencyDTOList) {
		
		try {
			countryCurrencyDTOList =  MapperUtil.getModelMapper(CountryCurrencyModelMapper.class)
					.entityListToDtoList(countryCurrencyProcessImpl.create(countryCurrencyDTOList));
			
		}
		catch(Exception e)
		{			
			logger.error("CountryCurrency create {}",e);
			throw e;
		}
		
		return countryCurrencyDTOList;
	}

	@Override
	public List<CountryCurrencyDTO> findAllList() {
		
		List<CountryCurrencyDTO> countryCurrencylist = null;
			try {
				countryCurrencylist = MapperUtil.getModelMapper(CountryCurrencyModelMapper.class)
						.entityListToDtoList(countryCurrencyProcessImpl.getAllEquimentListType());				 
		}
		catch(Exception e)
		{			
			logger.error("CountryCurrency findAllList {}",e);
			throw e;
		}
		
		return  countryCurrencylist;
	}

	@Override
	public CountryCurrencyUpdateDTO update(CountryCurrencyUpdateDTO countryCurrencyUpdateDTO) {
		try {
			countryCurrencyUpdateDTO = MapperUtil.getModelMapper(CountryCurrencyModelMapper.class)
					.entityToUpdateDTO(countryCurrencyProcessImpl.update(countryCurrencyUpdateDTO));				
		}
		catch(Exception e)
		{			
			logger.error("CountryCurrency update {}",e);
			throw e;
		}		
		return  countryCurrencyUpdateDTO;
	}

	@Override
	public void delete(String id) {
		try {
			countryCurrencyProcessImpl.delete(id);			 
		}
		catch(Exception e)
		{
			logger.error("CountryCurrency create {}",e);
			throw e;
		}
	}

	@Override
	public CountryCurrencyDTO findById(String id) {
		Optional<CountryCurrency> countryCurrency = null;
		CountryCurrencyDTO countryCurrencyDTO = null;		
		try {			
			countryCurrency = countryCurrencyProcessImpl.findById(id);
			
			if(countryCurrency.isPresent())
			{
				countryCurrencyDTO =  MapperUtil.getModelMapper(CountryCurrencyModelMapper.class)
						.entityToDto(countryCurrency.get());		
			}
			 
		}
		catch(Exception e)
		{			
			logger.error("CountryCurrency create {}",e);
			throw e;
		}		
		return countryCurrencyDTO;
	}

}
