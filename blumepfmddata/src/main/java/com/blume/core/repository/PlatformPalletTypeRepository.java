package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.PlatformPalletType;

public interface PlatformPalletTypeRepository extends  MongoRepository<PlatformPalletType, String> {

}
