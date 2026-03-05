package com.pnc.micron.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pnc.micron.advice.ProductNameNotFoundException;
import com.pnc.micron.advice.ProductPriceException;
import com.pnc.micron.model.Product;
import com.pnc.micron.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product productItem) {
		if(!StringUtils.hasText(productItem.getName())){
			throw new ProductNameNotFoundException("Required Product Name");
		}
		if(productItem.getPrice()<0){
			throw new ProductPriceException("price must be greater than 0 0");
		}
		return productRepository.save(productItem);
	}

	@Override
	public void deleteProduct(String id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Optional<Product> getProduct(String id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Product updateProduct(String id,Product product) {
		// TODO Auto-generated method stub
		if(productRepository.existsById(id)) {
			product.setId(id);
			return productRepository.save(product);
		}
		return null;
	}

}
