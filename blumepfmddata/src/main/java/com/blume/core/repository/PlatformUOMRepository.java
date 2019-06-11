package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformUOM;

public interface PlatformUOMRepository extends  MongoRepository<PlatformUOM, String> {

}
