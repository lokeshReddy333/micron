package com.otto.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.otto.product.model.Product;
/**
 * Repository interface for managing entities.
 * Provides CURD operaations for the product catalog.
 * @author Lokeswara Jangam
 *
 */

@Repository
public interface ProductRepository extends CrudRepository<Product,String> {

}
