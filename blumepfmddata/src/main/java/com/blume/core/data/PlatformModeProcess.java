package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformModeDTO;
import com.blume.core.dto.PlatformModeUpdateDTO;
import com.blume.core.model.PlatformMode;

public interface PlatformModeProcess {
	
	public List<PlatformMode> create(List<PlatformModeDTO> platformModeDTO);

	List<PlatformMode> findAllList();

	public PlatformMode update(PlatformModeUpdateDTO platformModeUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformMode> viewById(String id);

}
