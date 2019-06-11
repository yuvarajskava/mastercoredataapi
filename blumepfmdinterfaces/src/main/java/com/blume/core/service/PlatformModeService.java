package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformModeDTO;
import com.blume.core.dto.PlatformModeUpdateDTO;

public interface PlatformModeService {
	
	public List<PlatformModeDTO> create(List<PlatformModeDTO> platformModeDTO);

	public List<PlatformModeDTO> findAllList();

	public PlatformModeUpdateDTO update(PlatformModeUpdateDTO platformModeUpdateDTO);

	public void delete(String id);
	
	public PlatformModeDTO findById(String id);

}
