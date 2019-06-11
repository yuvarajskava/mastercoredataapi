package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformRateBasisProcess;
import com.blume.core.dto.PlatformRateBasisDTO;
import com.blume.core.dto.PlatformRateBasisUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformRateBasisModelMapper;
import com.blume.core.model.PlatformRateBasis;
import com.blume.core.repository.PlatformRateBasisRepository;


@Service
public class PlatformRateBasisProcessImpl implements PlatformRateBasisProcess {	

	@Autowired
	private PlatformRateBasisRepository platformRateBasisRepository;

	public List<PlatformRateBasis> findAllList() {
		return platformRateBasisRepository.findAll(); 
	}

	public List<PlatformRateBasis> create(List<PlatformRateBasisDTO> platformRateBasisDTOList) {
		List<PlatformRateBasis> platformRateBasisList= MapperUtil.getModelMapper(PlatformRateBasisModelMapper.class).dtoListToEntityList(platformRateBasisDTOList);
		platformRateBasisList = platformRateBasisRepository.saveAll(platformRateBasisList);
		return platformRateBasisList;
	}

	public PlatformRateBasis update(PlatformRateBasisUpdateDTO platformRateBasisUpdateDTO) {
		PlatformRateBasis platformRateBasis = null;

		platformRateBasis = MapperUtil.getModelMapper(PlatformRateBasisModelMapper.class)
				.updatedtoToEntity(platformRateBasisUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformRateBasis.setUpdatedTimeStamp(currentTime);

		Optional<PlatformRateBasis> platformRateBasisUdate = platformRateBasisRepository.findById(platformRateBasis.getId());		
		if(platformRateBasisUdate.isPresent())
		{
			platformRateBasis.setCreatedBy(platformRateBasisUdate.get().getCreatedBy());
			platformRateBasis.setCreatedTimeStamp(platformRateBasisUdate.get().getCreatedTimeStamp());
		}

		return platformRateBasisRepository.save(platformRateBasis);

	}

	public void delete(String id) {

		platformRateBasisRepository.deleteById(id);
	}

	public Optional<PlatformRateBasis> viewById(String id) {
		
		return platformRateBasisRepository.findById(id);

	}

}
