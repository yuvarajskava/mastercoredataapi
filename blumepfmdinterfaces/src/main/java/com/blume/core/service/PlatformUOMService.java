package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformUOMDTO;
import com.blume.core.dto.PlatformUOMUpdateDTO;

public interface PlatformUOMService {
	
	public List<PlatformUOMDTO> create(List<PlatformUOMDTO> platformUOMDTO);

	public List<PlatformUOMDTO> findAllList();

	public PlatformUOMUpdateDTO update(PlatformUOMUpdateDTO platformUOMUpdateDTO);

	public void delete(String id);
	
	public PlatformUOMDTO findById(String id);

}
