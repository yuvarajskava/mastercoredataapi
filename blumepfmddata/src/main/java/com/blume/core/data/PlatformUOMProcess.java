package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformUOMDTO;
import com.blume.core.dto.PlatformUOMUpdateDTO;
import com.blume.core.model.PlatformUOM;

public interface PlatformUOMProcess {
	
	public List<PlatformUOM> create(List<PlatformUOMDTO> platformUOMDTO);

	List<PlatformUOM> findAllList();

	public PlatformUOM update(PlatformUOMUpdateDTO platformUOMUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformUOM> viewById(String id);

}
