package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformUOMProcess;
import com.blume.core.dto.PlatformUOMDTO;
import com.blume.core.dto.PlatformUOMUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformUOMModelMapper;
import com.blume.core.model.PlatformUOM;
import com.blume.core.repository.PlatformUOMRepository;


@Service
public class PlatformUOMProcessImpl implements PlatformUOMProcess {	

	@Autowired
	private PlatformUOMRepository platformUOMRepository;

	public List<PlatformUOM> findAllList() {
		return platformUOMRepository.findAll();
	}

	public List<PlatformUOM> create(List<PlatformUOMDTO> platformUOMDTOList) {
		List<PlatformUOM> platformUOMList = MapperUtil.getModelMapper(PlatformUOMModelMapper.class).dtoListToEntityList(platformUOMDTOList);
		platformUOMList = platformUOMRepository.saveAll(platformUOMList);
		return platformUOMList;
	}

	public PlatformUOM update(PlatformUOMUpdateDTO platformUOMUpdateDTO) {
		PlatformUOM platformUOM = null;

		platformUOM = MapperUtil.getModelMapper(PlatformUOMModelMapper.class)
				.updatedtoToEntity(platformUOMUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformUOM.setUpdatedTimeStamp(currentTime);

		Optional<PlatformUOM> platformUOMUdate = platformUOMRepository.findById(platformUOM.getId());		
		if(platformUOMUdate.isPresent())
		{
			platformUOM.setCreatedBy(platformUOMUdate.get().getCreatedBy());
			platformUOM.setCreatedTimeStamp(platformUOMUdate.get().getCreatedTimeStamp());
		}

		return platformUOMRepository.save(platformUOM);

	}

	public void delete(String id) {

		platformUOMRepository.deleteById(id);
	}

	public Optional<PlatformUOM> viewById(String id) {
		
		return platformUOMRepository.findById(id);

	}

}
