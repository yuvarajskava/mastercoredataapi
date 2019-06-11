package com.blume.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blume.core.model.CountryCurrency;

public interface CountryCurrencyRepository extends  MongoRepository<CountryCurrency, String> {

}
