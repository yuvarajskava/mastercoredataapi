package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.CountryCurrencyProcess;
import com.blume.core.dto.CountryCurrencyDTO;
import com.blume.core.dto.CountryCurrencyUpdateDTO;
import com.blume.core.mapper.CountryCurrencyModelMapper;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.model.CountryCurrency;
import com.blume.core.repository.CountryCurrencyRepository;


@Service
public class CountryCurrencyProcessImpl implements CountryCurrencyProcess {	

	@Autowired
	private CountryCurrencyRepository countryCurrencyRepository;

	public List<CountryCurrency> getAllEquimentListType() {
		return countryCurrencyRepository.findAll();
	}

	public List<CountryCurrency> create(List<CountryCurrencyDTO> countryCurrencyDTOList) {
		
		List<CountryCurrency>  countryCurrencyList = MapperUtil.getModelMapper(CountryCurrencyModelMapper.class).dtoListToEntityList(countryCurrencyDTOList);
		countryCurrencyList = countryCurrencyRepository.saveAll(countryCurrencyList);
		return countryCurrencyList;
	}

	public CountryCurrency update(CountryCurrencyUpdateDTO countryCurrencyUpdateDTO) {
		CountryCurrency countryCurrency = null;

		countryCurrency = MapperUtil.getModelMapper(CountryCurrencyModelMapper.class)
				.updatedtoToEntity(countryCurrencyUpdateDTO);
		long currentTime = System.currentTimeMillis();
		countryCurrency.setUpdatedTimeStamp(currentTime);

		Optional<CountryCurrency> countryCurrencyUdate = countryCurrencyRepository.findById(countryCurrency.getId());		
		if(countryCurrencyUdate.isPresent())
		{
			countryCurrency.setCreatedBy(countryCurrencyUdate.get().getCreatedBy());
			countryCurrency.setCreatedTimeStamp(countryCurrencyUdate.get().getCreatedTimeStamp());
		}

		return countryCurrencyRepository.save(countryCurrency);

	}

	public void delete(String id) {

		countryCurrencyRepository.deleteById(id);
	}

	public Optional<CountryCurrency> findById(String id) {
		
		return countryCurrencyRepository.findById(id);

	}
	
}
