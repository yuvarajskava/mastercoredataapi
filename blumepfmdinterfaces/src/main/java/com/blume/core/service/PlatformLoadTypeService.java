package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformLoadTypeDTO;
import com.blume.core.dto.PlatformLoadTypeUpdateDTO;

public interface PlatformLoadTypeService {
	
	public List<PlatformLoadTypeDTO> create(List<PlatformLoadTypeDTO> platformLoadTypeDTO);

	public List<PlatformLoadTypeDTO> findAllList();

	public PlatformLoadTypeUpdateDTO update(PlatformLoadTypeUpdateDTO platformLoadTypeUpdateDTO);

	public void delete(String id);
	
	public PlatformLoadTypeDTO findById(String id);

}
