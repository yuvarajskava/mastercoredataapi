package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformMoveType;

public interface PlatformMoveTypeRepository extends  MongoRepository<PlatformMoveType, String> {

}
