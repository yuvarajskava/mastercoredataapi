package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformRateBasisDTO;
import com.blume.core.dto.PlatformRateBasisUpdateDTO;
import com.blume.core.model.PlatformRateBasis;

public interface PlatformRateBasisProcess {
	
	public List<PlatformRateBasis> create(List<PlatformRateBasisDTO> platformRateBasisDTO);

	List<PlatformRateBasis> findAllList();

	public PlatformRateBasis update(PlatformRateBasisUpdateDTO platformRateBasisUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformRateBasis> viewById(String id);

}
