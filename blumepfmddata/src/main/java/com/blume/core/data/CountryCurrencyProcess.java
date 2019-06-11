package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.CountryCurrencyDTO;
import com.blume.core.dto.CountryCurrencyUpdateDTO;
import com.blume.core.model.CountryCurrency;

public interface CountryCurrencyProcess {
	
	public List<CountryCurrency> create(List<CountryCurrencyDTO> countryCurrencyDTO);

	List<CountryCurrency> getAllEquimentListType();

	public CountryCurrency update(CountryCurrencyUpdateDTO countryCurrencyUpdateDTO);

	public void delete(String id);
	
	public Optional<CountryCurrency> findById(String id);

}
