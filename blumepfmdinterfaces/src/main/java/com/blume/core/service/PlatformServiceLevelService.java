package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformServiceLevelDTO;
import com.blume.core.dto.PlatformServiceLevelUpdateDTO;

public interface PlatformServiceLevelService {
	
	public List<PlatformServiceLevelDTO> create(List<PlatformServiceLevelDTO> platformServiceLevelDTO);

	public List<PlatformServiceLevelDTO> findAllList();

	public PlatformServiceLevelUpdateDTO update(PlatformServiceLevelUpdateDTO platformServiceLevelUpdateDTO);

	public void delete(String id);
	
	public PlatformServiceLevelDTO findById(String id);

}
