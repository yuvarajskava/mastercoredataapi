package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformMode;

public interface PlatformModeRepository extends  MongoRepository<PlatformMode, String> {

}
