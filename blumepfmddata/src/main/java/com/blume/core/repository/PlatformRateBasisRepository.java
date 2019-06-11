package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformRateBasis;

public interface PlatformRateBasisRepository extends  MongoRepository<PlatformRateBasis, String> {

}
