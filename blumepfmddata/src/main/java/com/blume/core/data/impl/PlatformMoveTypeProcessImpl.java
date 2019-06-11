package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformMoveTypeProcess;
import com.blume.core.dto.PlatformMoveTypeDTO;
import com.blume.core.dto.PlatformMoveTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformMoveTypeModelMapper;
import com.blume.core.model.PlatformMoveType;
import com.blume.core.repository.PlatformMoveTypeRepository;


@Service
public class PlatformMoveTypeProcessImpl implements PlatformMoveTypeProcess {	

	@Autowired
	private PlatformMoveTypeRepository platformMoveTypeRepository;

	public List<PlatformMoveType> findAllList() {
		return platformMoveTypeRepository.findAll();
	}

	public List<PlatformMoveType> create(List<PlatformMoveTypeDTO> platformMoveTypeDTOList) {		 
		List<PlatformMoveType> platformMoveTypeList = MapperUtil.getModelMapper(PlatformMoveTypeModelMapper.class).dtoListToEntityList(platformMoveTypeDTOList);
		platformMoveTypeList = platformMoveTypeRepository.saveAll(platformMoveTypeList);
		return platformMoveTypeList;
	}

	public PlatformMoveType update(PlatformMoveTypeUpdateDTO platformMoveTypeUpdateDTO) {
		PlatformMoveType platformMoveType = null;

		platformMoveType = MapperUtil.getModelMapper(PlatformMoveTypeModelMapper.class)
				.updatedtoToEntity(platformMoveTypeUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformMoveType.setUpdatedTimeStamp(currentTime);

		Optional<PlatformMoveType> platformMoveTypeUdate = platformMoveTypeRepository.findById(platformMoveType.getId());		
		if(platformMoveTypeUdate.isPresent())
		{
			platformMoveType.setCreatedBy(platformMoveTypeUdate.get().getCreatedBy());
			platformMoveType.setCreatedTimeStamp(platformMoveTypeUdate.get().getCreatedTimeStamp());
		}

		return platformMoveTypeRepository.save(platformMoveType);

	}

	public void delete(String id) {

		platformMoveTypeRepository.deleteById(id);
	}

	public Optional<PlatformMoveType> viewById(String id) {
		
		return platformMoveTypeRepository.findById(id);

	}

}
