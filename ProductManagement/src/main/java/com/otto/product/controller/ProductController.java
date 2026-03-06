package com.otto.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.otto.product.model.Product;
import com.otto.product.services.ProductService;

/**
 * REST Controller Providing endpoints for Product Management.
 * Handles CURD operations by delegating business login to {@link ProductService}.
 * @author Lokeswara Jangam
 *
 */
@RestController
@RequestMapping("/otto")
public class ProductController {

	private ProductService productService;
	
	private ProductController(ProductService productService) {
		this.productService=productService;
	}
	/**
	 * Creates a new product entity in the system.
	 * @param product details provided in the request body.
	 * @return The saved product object with a 201 Created status.
	 */
	@PostMapping(value="/products",produces={"application/json"}, consumes= {"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		 return productService.addProduct(product);
	}
	/**
	 * Retrieves a specific product by its unique identifier.
	 * @param id The unique string ID of the product.
	 * @return An Optional containing the product if found , or empty if not.
	 */
	@GetMapping(value="/products/{id}",produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public Optional<Product> getproduct(@PathVariable("id")String id) {
		return productService.getProduct(id);
	}
	/**
	 * Retrieves all products in the system.
	 * @return List of products.
	 */
	@GetMapping(value="/products",produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getproducts() {
		return productService.getAll();
	}
	/**
	 * Updates an existing product's information.
	 * @param id The ID of the product to update.
	 * @param product The updated product data.
	 * @return The updated Product object
	 */
	@PutMapping(value="/products/{id}",produces={"application/json"}, consumes= {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public Product getProducts(@PathVariable String id,@RequestBody Product product) {
		return productService.updateProduct(id,product);
	}
	/**
	 * Removes a product from the system.
	 * @param id The ID of the product to be deleted.
	 */
	@DeleteMapping(value="/product/{id}",produces={"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable String id) {
		productService.deleteProduct(id);
	}
}
