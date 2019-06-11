package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.CommodityClass;

public interface CommodityClassRepository extends  MongoRepository<CommodityClass, String> {

}
