package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformMoveTypeDTO;
import com.blume.core.dto.PlatformMoveTypeUpdateDTO;

public interface PlatformMoveTypeService {
	
	public List<PlatformMoveTypeDTO> create(List<PlatformMoveTypeDTO> platformMoveTypeDTO);

	public List<PlatformMoveTypeDTO> findAllList();

	public PlatformMoveTypeUpdateDTO update(PlatformMoveTypeUpdateDTO platformMoveTypeUpdateDTO);

	public void delete(String id);
	
	public PlatformMoveTypeDTO findById(String id);

}
