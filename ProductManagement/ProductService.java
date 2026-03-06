package com.otto.product.services;

import java.util.List;
import java.util.Optional;

import com.otto.product.model.Product;
/**
 * Service interface for managing product business logic
 * @author Lokeswara Jangam
 *
 */

public interface ProductService {
	
	Product addProduct(Product product);
	void deleteProduct(String name);
	Optional<Product> getProduct(String id);
	List<Product> getAll();	
	Product updateProduct(String id,Product product);

}
