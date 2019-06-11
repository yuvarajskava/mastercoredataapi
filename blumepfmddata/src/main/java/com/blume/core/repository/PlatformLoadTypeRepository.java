package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformLoadType;

public interface PlatformLoadTypeRepository extends  MongoRepository<PlatformLoadType, String> {

}
