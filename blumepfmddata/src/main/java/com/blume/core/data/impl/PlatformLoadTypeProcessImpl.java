package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformLoadTypeProcess;
import com.blume.core.dto.PlatformLoadTypeDTO;
import com.blume.core.dto.PlatformLoadTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformLoadTypeModelMapper;
import com.blume.core.model.PlatformLoadType;
import com.blume.core.repository.PlatformLoadTypeRepository;


@Service
public class PlatformLoadTypeProcessImpl implements PlatformLoadTypeProcess {	

	@Autowired
	private PlatformLoadTypeRepository platformLoadTypeRepository;

	public List<PlatformLoadType> findAllList() {
		return platformLoadTypeRepository.findAll();
	}

	public List<PlatformLoadType> create(List<PlatformLoadTypeDTO> platformLoadTypeDTOList) {		 
		List<PlatformLoadType> platformLoadTypeList = MapperUtil.getModelMapper(PlatformLoadTypeModelMapper.class).dtoListToEntityList(platformLoadTypeDTOList);
		
		platformLoadTypeList = platformLoadTypeRepository.saveAll(platformLoadTypeList);
		return platformLoadTypeList;
	}

	public PlatformLoadType update(PlatformLoadTypeUpdateDTO platformLoadTypeUpdateDTO) {
		PlatformLoadType platformLoadType = null;

		platformLoadType = MapperUtil.getModelMapper(PlatformLoadTypeModelMapper.class)
				.updatedtoToEntity(platformLoadTypeUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformLoadType.setUpdatedTimeStamp(currentTime);

		Optional<PlatformLoadType> platformLoadTypeUdate = platformLoadTypeRepository.findById(platformLoadType.getId());		
		if(platformLoadTypeUdate.isPresent())
		{
			platformLoadType.setCreatedBy(platformLoadTypeUdate.get().getCreatedBy());
			platformLoadType.setCreatedTimeStamp(platformLoadTypeUdate.get().getCreatedTimeStamp());
		}

		return platformLoadTypeRepository.save(platformLoadType);

	}

	public void delete(String id) {

		platformLoadTypeRepository.deleteById(id);
	}

	public Optional<PlatformLoadType> viewById(String id) {
		
		return platformLoadTypeRepository.findById(id);

	}	 

}
