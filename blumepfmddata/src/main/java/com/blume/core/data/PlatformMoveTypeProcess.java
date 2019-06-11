package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformMoveTypeDTO;
import com.blume.core.dto.PlatformMoveTypeUpdateDTO;
import com.blume.core.model.PlatformMoveType;

public interface PlatformMoveTypeProcess {
	
	public List<PlatformMoveType> create(List<PlatformMoveTypeDTO> platformMoveTypeDTO);

	List<PlatformMoveType> findAllList();

	public PlatformMoveType update(PlatformMoveTypeUpdateDTO platformMoveTypeUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformMoveType> viewById(String id);

}
