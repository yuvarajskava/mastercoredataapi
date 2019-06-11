package com.blume.core.data;

import java.util.List;
import java.util.Optional;

import com.blume.core.dto.CommodityClassDTO;
import com.blume.core.dto.CommodityClassUpdateDTO;
import com.blume.core.model.CommodityClass;

public interface CommodityClassProcess {
	
	public List<CommodityClass> create(List<CommodityClassDTO> commodityClassDTO);

	List<CommodityClass> getAllCommodity();

	public CommodityClass update(CommodityClassUpdateDTO commodityClassUpdateDTO);

	public void delete(String id);
	
	public Optional<CommodityClass> viewById(String id);

}
