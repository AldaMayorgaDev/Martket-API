package com.platzi.APIPlatziMarket.persistence.crud;

import com.platzi.APIPlatziMarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}
