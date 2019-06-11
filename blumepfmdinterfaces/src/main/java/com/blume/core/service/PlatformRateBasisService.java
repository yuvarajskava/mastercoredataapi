package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformRateBasisDTO;
import com.blume.core.dto.PlatformRateBasisUpdateDTO;

public interface PlatformRateBasisService {
	
	public List<PlatformRateBasisDTO> create(List<PlatformRateBasisDTO> platformRateBasisDTO);

	public List<PlatformRateBasisDTO> findAllList();

	public PlatformRateBasisUpdateDTO update(PlatformRateBasisUpdateDTO platformRateBasisUpdateDTO);

	public void delete(String id);
	
	public PlatformRateBasisDTO findById(String id);

}
