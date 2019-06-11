package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.PlatformTripTypeDTO;
import com.blume.core.dto.PlatformTripTypeUpdateDTO;

public interface PlatformTripTypeService {
	
	public List<PlatformTripTypeDTO> create(List<PlatformTripTypeDTO> platformTripTypeDTO);

	public List<PlatformTripTypeDTO> findAllList();

	public PlatformTripTypeUpdateDTO update(PlatformTripTypeUpdateDTO platformTripTypeUpdateDTO);

	public void delete(String id);
	
	public PlatformTripTypeDTO findById(String id);

}
