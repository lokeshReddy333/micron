package com.otto.product.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.otto.product.advice.ProductIdNotFoundException;
import com.otto.product.advice.ProductNameNotFoundException;
import com.otto.product.advice.ProductPriceException;
import com.otto.product.model.Product;
import com.otto.product.repository.ProductRepository;

/**
 * Service implementation class for managing product entities
 * @author Lokeswara Jangam
 *
 */

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Add a new product
	 * @param The product to add
	 * @return The saved product
	 * @throws ProductNameNotFoundException,ProductPriceException
	 */
	@Override
	public Product addProduct(Product product) {
		if(!StringUtils.hasText(product.getName())){
			throw new ProductNameNotFoundException("Required Product Name");
		}
		if(product.getPrice()<0){
			throw new ProductPriceException("price must be greater than 0");
		}
		return productRepository.save(product);
	}
	/**
	 * Deletes a product by ID
	 * @Param id The ID of th product.
	 * @throws
	 * productIdNotFoundException if no product exists with that ID.
	 */

	@Override
	public void deleteProduct(String id) {
		if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
		}
		throw new ProductIdNotFoundException("Id not found "+id);
		
	}
	/**
	 * Retrieve a product ID
	 * @Param id The ID of th product.
	 * @throws
	 * productIdNotFoundException if no product exists with that ID.
	 */

	@Override
	public Optional<Product> getProduct(String id) {
		if(productRepository.existsById(id)) {
			return productRepository.findById(id);
		}
		throw new ProductIdNotFoundException("product Id not found "+id+"please try valid product Id");
		
	}
	/**
	 * Retrieve all products in the system.
	 */

	@Override
	public List<Product> getAll() {
		return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
	
	/**
	 * update product by ID
	 * @Param id The ID of th product.
	 * @param product entity
	 * @throws
	 * productIdNotFoundException if no product exists with that ID.
	 */
	@Override
	public Product updateProduct(String id,Product product) {
		if(productRepository.existsById(id)) {
			product.setId(id);
			return productRepository.save(product);
		}
		throw new ProductIdNotFoundException("Id not found "+id);
	}

}
