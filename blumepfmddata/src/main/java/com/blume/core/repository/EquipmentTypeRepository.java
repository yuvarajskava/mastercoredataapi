package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.EquipmentType;

public interface EquipmentTypeRepository extends MongoRepository<EquipmentType, String> {

}
