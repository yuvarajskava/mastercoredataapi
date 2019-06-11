package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformServiceLevelProcess;
import com.blume.core.dto.PlatformServiceLevelDTO;
import com.blume.core.dto.PlatformServiceLevelUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformServiceLevelModelMapper;
import com.blume.core.model.PlatformServiceLevel;
import com.blume.core.repository.PlatformServiceLevelRepository;


@Service
public class PlatformServiceLevelProcessImpl implements PlatformServiceLevelProcess {	

	@Autowired
	private PlatformServiceLevelRepository platformServiceLevelRepository;

	public List<PlatformServiceLevel> findAllList() {
		return platformServiceLevelRepository.findAll();
	}

	public List<PlatformServiceLevel> create(List<PlatformServiceLevelDTO> platformServiceLevelDTOList) {
		List<PlatformServiceLevel> platformServiceLevelList = MapperUtil.getModelMapper(PlatformServiceLevelModelMapper.class).dtoListToEntityList(platformServiceLevelDTOList);
		platformServiceLevelList = platformServiceLevelRepository.saveAll(platformServiceLevelList);
		return platformServiceLevelList;
	}

	public PlatformServiceLevel update(PlatformServiceLevelUpdateDTO platformServiceLevelUpdateDTO) {
		PlatformServiceLevel platformServiceLevel = null;

		platformServiceLevel = MapperUtil.getModelMapper(PlatformServiceLevelModelMapper.class)
				.updatedtoToEntity(platformServiceLevelUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformServiceLevel.setUpdatedTimeStamp(currentTime);

		Optional<PlatformServiceLevel> platformServiceLevelUdate = platformServiceLevelRepository.findById(platformServiceLevel.getId());		
		if(platformServiceLevelUdate.isPresent())
		{
			platformServiceLevel.setCreatedBy(platformServiceLevelUdate.get().getCreatedBy());
			platformServiceLevel.setCreatedTimeStamp(platformServiceLevelUdate.get().getCreatedTimeStamp());
		}

		return platformServiceLevelRepository.save(platformServiceLevel);

	}

	public void delete(String id) {

		platformServiceLevelRepository.deleteById(id);
	}

	public Optional<PlatformServiceLevel> viewById(String id) {
		
		return platformServiceLevelRepository.findById(id);

	}

}
