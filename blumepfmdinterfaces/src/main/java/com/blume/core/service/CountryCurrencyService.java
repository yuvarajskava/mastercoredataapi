package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.CountryCurrencyDTO;
import com.blume.core.dto.CountryCurrencyUpdateDTO;

public interface CountryCurrencyService {
	
	public List<CountryCurrencyDTO> create(List<CountryCurrencyDTO> countryCurrencyDTO);

	public List<CountryCurrencyDTO> findAllList();

	public CountryCurrencyUpdateDTO update(CountryCurrencyUpdateDTO countryCurrencyUpdateDTO);

	public void delete(String id);
	
	public CountryCurrencyDTO findById(String id);

}
