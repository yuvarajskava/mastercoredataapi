package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformTripTypeProcess;
import com.blume.core.dto.PlatformTripTypeDTO;
import com.blume.core.dto.PlatformTripTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformTripTypeModelMapper;
import com.blume.core.model.PlatformTripType;
import com.blume.core.repository.PlatformTripTypeRepository;


@Service
public class PlatformTripTypeProcessImpl implements PlatformTripTypeProcess {	

	@Autowired
	private PlatformTripTypeRepository platformTripTypeRepository;

	public List<PlatformTripType> findAllList() {
		return platformTripTypeRepository.findAll();
	}

	public List<PlatformTripType> create(List<PlatformTripTypeDTO> platformTripTypeDTOList) {
		List<PlatformTripType> platformTripTypeList = MapperUtil.getModelMapper(PlatformTripTypeModelMapper.class).dtoListToEntityList(platformTripTypeDTOList);
		platformTripTypeList = platformTripTypeRepository.saveAll(platformTripTypeList);
		return platformTripTypeList;
	}

	public PlatformTripType update(PlatformTripTypeUpdateDTO platformTripTypeUpdateDTO) {
		PlatformTripType platformTripType = null;

		platformTripType = MapperUtil.getModelMapper(PlatformTripTypeModelMapper.class)
				.updatedtoToEntity(platformTripTypeUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformTripType.setUpdatedTimeStamp(currentTime);

		Optional<PlatformTripType> platformTripTypeUdate = platformTripTypeRepository.findById(platformTripType.getId());		
		if(platformTripTypeUdate.isPresent())
		{
			platformTripType.setCreatedBy(platformTripTypeUdate.get().getCreatedBy());
			platformTripType.setCreatedTimeStamp(platformTripTypeUdate.get().getCreatedTimeStamp());
		}

		return platformTripTypeRepository.save(platformTripType);

	}

	public void delete(String id) {

		platformTripTypeRepository.deleteById(id);
	}

	public Optional<PlatformTripType> viewById(String id) {
		
		return platformTripTypeRepository.findById(id);

	}

}
