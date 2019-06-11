package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformPalletTypeDTO;
import com.blume.core.dto.PlatformPalletTypeUpdateDTO;
import com.blume.core.model.PlatformPalletType;

public interface PlatformPalletTypeProcess {
	
	public List<PlatformPalletType> create(List<PlatformPalletTypeDTO> platformPalletTypeDTOList);

	List<PlatformPalletType> findAllList();

	public PlatformPalletType update(PlatformPalletTypeUpdateDTO platformPalletTypeUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformPalletType> viewById(String id);

}
