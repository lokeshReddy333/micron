package com.pnc.micron.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pnc.micron.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,String> {

}
