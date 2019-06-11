package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformPalletTypeDTO;
import com.blume.core.dto.PlatformPalletTypeUpdateDTO;

public interface PlatformPalletTypeService {
	
	public List<PlatformPalletTypeDTO> create(List<PlatformPalletTypeDTO> platformPalletTypeDTOList);

	public List<PlatformPalletTypeDTO> findAllList();

	public PlatformPalletTypeUpdateDTO update(PlatformPalletTypeUpdateDTO platformPalletTypeUpdateDTO);

	public void delete(String id);
	
	public PlatformPalletTypeDTO findById(String id);

}
