package com.pnc.micron.controller;

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

import com.pnc.micron.advice.ProductNameNotFoundException;
import com.pnc.micron.model.Product;
import com.pnc.micron.services.ProductService;



@RestController
//@RequestMapping("${spring.application.basePath}")
@RequestMapping("/otto")
public class ProductController {

	private ProductService productService;
	private ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@PostMapping(value="/products",produces={"application/json"}, consumes= {"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product productItem) {
		 return productService.addProduct(productItem);
	}
	@GetMapping(value="/products/{id}",produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public Optional<Product> getproduct(@PathVariable("id")String id) {
		return productService.getProduct(id);
	}
	@GetMapping(value="/products",produces={"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getproducts() {
		return productService.getAll();
	}
	@PutMapping(value="/products/{id}",produces={"application/json"}, consumes= {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public Product getProducts(@PathVariable String id,@RequestBody Product product) {
		return productService.updateProduct(id,product);
	}
	@DeleteMapping(value="/product/{id}",produces={"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable String id) {
		productService.deleteProduct(id);
	}
}
