package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformServiceLevel;

public interface PlatformServiceLevelRepository extends  MongoRepository<PlatformServiceLevel, String> {

}
