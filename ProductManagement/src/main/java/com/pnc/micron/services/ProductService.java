package com.pnc.micron.services;

import java.util.List;
import java.util.Optional;

import com.pnc.micron.model.Product;

public interface ProductService {
	
	Product addProduct(Product productItem);
	void deleteProduct(String name);
	Optional<Product> getProduct(String id);
	List<Product> getAll();	
	Product updateProduct(String id,Product product);

}
