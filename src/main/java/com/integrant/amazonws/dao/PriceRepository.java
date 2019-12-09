package com.integrant.amazonws.dao;

import com.integrant.amazonws.entity.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Integer> {
}
