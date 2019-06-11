package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.PlatformTripTypeDTO;
import com.blume.core.dto.PlatformTripTypeUpdateDTO;
import com.blume.core.model.PlatformTripType;

public interface PlatformTripTypeProcess {
	
	public List<PlatformTripType> create(List<PlatformTripTypeDTO> platformTripTypeDTO);

	List<PlatformTripType> findAllList();

	public PlatformTripType update(PlatformTripTypeUpdateDTO platformTripTypeUpdateDTO);

	public void delete(String id);
	
	public Optional<PlatformTripType> viewById(String id);

}
