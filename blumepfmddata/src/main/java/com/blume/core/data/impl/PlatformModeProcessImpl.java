package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformModeProcess;
import com.blume.core.dto.PlatformModeDTO;
import com.blume.core.dto.PlatformModeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformModeModelMapper;
import com.blume.core.model.PlatformMode;
import com.blume.core.repository.PlatformModeRepository;


@Service
public class PlatformModeProcessImpl implements PlatformModeProcess {	

	@Autowired
	private PlatformModeRepository platformModeRepository;

	public List<PlatformMode> findAllList() {
		return platformModeRepository.findAll();
	}

	public List<PlatformMode> create(List<PlatformModeDTO> platformModeDTOList) {		
		List<PlatformMode> platformModeList = MapperUtil.getModelMapper(PlatformModeModelMapper.class).dtoListToEntityList(platformModeDTOList);
		platformModeList = platformModeRepository.saveAll(platformModeList);
		return platformModeList;
	}

	public PlatformMode update(PlatformModeUpdateDTO platformModeUpdateDTO) {
		PlatformMode platformMode = null;

		platformMode = MapperUtil.getModelMapper(PlatformModeModelMapper.class)
				.updatedtoToEntity(platformModeUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformMode.setUpdatedTimeStamp(currentTime);

		Optional<PlatformMode> platformModeUdate = platformModeRepository.findById(platformMode.getId());		
		if(platformModeUdate.isPresent())
		{
			platformMode.setCreatedBy(platformModeUdate.get().getCreatedBy());
			platformMode.setCreatedTimeStamp(platformModeUdate.get().getCreatedTimeStamp());
		}

		return platformModeRepository.save(platformMode);

	}

	public void delete(String id) {

		platformModeRepository.deleteById(id);
	}

	public Optional<PlatformMode> viewById(String id) {
		
		return platformModeRepository.findById(id);

	}

}
