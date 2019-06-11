package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformServiceLevelDTO;
import com.blume.core.dto.PlatformServiceLevelUpdateDTO;
import com.blume.core.model.PlatformServiceLevel;

public interface PlatformServiceLevelProcess {
	
	public List<PlatformServiceLevel> create(List<PlatformServiceLevelDTO> platformServiceLevelDTO);

	List<PlatformServiceLevel> findAllList();

	public PlatformServiceLevel update(PlatformServiceLevelUpdateDTO platformServiceLevelUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformServiceLevel> viewById(String id);

}
