package com.blume.core.service;

import java.util.List;

import com.blume.core.dto.CommodityClassDTO;
import com.blume.core.dto.CommodityClassUpdateDTO;

public interface CommodityClassService {
	
	public List<CommodityClassDTO> create(List<CommodityClassDTO> commodityClassDTO);

	public List<CommodityClassDTO> findAllList();

	public CommodityClassUpdateDTO update(CommodityClassUpdateDTO commodityClassUpdateDTO);

	public void delete(String id);
	
	public CommodityClassDTO findById(String id);

}
