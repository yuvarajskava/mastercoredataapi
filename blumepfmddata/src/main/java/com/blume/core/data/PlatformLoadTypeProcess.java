package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformLoadTypeDTO;
import com.blume.core.dto.PlatformLoadTypeUpdateDTO;
import com.blume.core.model.PlatformLoadType;

public interface PlatformLoadTypeProcess {
	
	public List<PlatformLoadType> create(List<PlatformLoadTypeDTO> platformLoadTypeDTO);

	List<PlatformLoadType> findAllList();

	public PlatformLoadType update(PlatformLoadTypeUpdateDTO platformLoadTypeUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformLoadType> viewById(String id);

}
