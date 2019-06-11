package com.blume.core.data.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blume.core.data.PlatformPalletTypeProcess;
import com.blume.core.dto.PlatformPalletTypeDTO;
import com.blume.core.dto.PlatformPalletTypeUpdateDTO;
import com.blume.core.mapper.MapperUtil;
import com.blume.core.mapper.PlatformPalletTypeModelMapper;
import com.blume.core.model.PlatformPalletType;
import com.blume.core.repository.PlatformPalletTypeRepository;


@Service
public class PlatformPalletTypeProcessImpl implements PlatformPalletTypeProcess {	
 
	@Autowired
	private PlatformPalletTypeRepository platformPalletTypeRepository;

	public List<PlatformPalletType> findAllList() {
		return platformPalletTypeRepository.findAll();
	}

	public List<PlatformPalletType> create(List<PlatformPalletTypeDTO> platformPalletTypeDTOList) {		
		List<PlatformPalletType> platformPalletTypeList = MapperUtil.getModelMapper(PlatformPalletTypeModelMapper.class).dtoListToEntityList(platformPalletTypeDTOList);
		platformPalletTypeList = platformPalletTypeRepository.saveAll(platformPalletTypeList);
		return platformPalletTypeList;
	}

	public PlatformPalletType update(PlatformPalletTypeUpdateDTO platformPalletTypeUpdateDTO) {
		PlatformPalletType platformPalletType = null;

		platformPalletType = MapperUtil.getModelMapper(PlatformPalletTypeModelMapper.class)
				.updatedtoToEntity(platformPalletTypeUpdateDTO);
		long currentTime = System.currentTimeMillis();
		platformPalletType.setUpdatedTimeStamp(currentTime);

		Optional<PlatformPalletType> platformPalletTypeUdate = platformPalletTypeRepository.findById(platformPalletType.getId());		
		if(platformPalletTypeUdate.isPresent())
		{
			platformPalletType.setCreatedBy(platformPalletTypeUdate.get().getCreatedBy());
			platformPalletType.setCreatedTimeStamp(platformPalletTypeUdate.get().getCreatedTimeStamp());
		}

		return platformPalletTypeRepository.save(platformPalletType);

	}

	public void delete(String id) {

		platformPalletTypeRepository.deleteById(id);
	}

	public Optional<PlatformPalletType> viewById(String id) {
		
		return platformPalletTypeRepository.findById(id);

	}

}
