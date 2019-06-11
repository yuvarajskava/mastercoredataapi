package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformTripType;

public interface PlatformTripTypeRepository extends  MongoRepository<PlatformTripType, String> {

}
