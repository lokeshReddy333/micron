package com.otto.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.otto.product.advice.ProductNameNotFoundException;
import com.otto.product.advice.ProductPriceException;
import com.otto.product.model.Product;
import com.otto.product.repository.ProductRepository;
import com.otto.product.services.ProductServiceImpl;

/**
 * Unit test for ProductServiceImpl
 * Verifies business logic for product management, including
 * validation constraints and repository interactions
 * @author Lokeswara Jangam
 *
 */
public class ProductServiceImplTest {

	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductServiceImpl productService;
	Product product;
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		product =new Product();
		product.setId("123");
		product.setName("mobile");
		product.setPrice(1000.0);
		
	}
	@Test
	void testAddProductSuccess() {
		
		when(productRepository.save(product)).thenReturn(product);
		Product saveProduct = productService.addProduct(product);
		assertNotNull(saveProduct);
		assertEquals("mobile",saveProduct.getName());
	}
	@Test
	void testAddProuctNameEmpty() {
		product.setName("");
		assertThrows(ProductNameNotFoundException.class,()->{
			productService.addProduct(product);
		});
	}
	@Test
	void testAddProductPriceInvalid() {
		product.setPrice(-10.00);
		assertThrows(ProductPriceException.class,()->{
			productService.addProduct(product);
		});
	}
	@Test
	void testGetProduct() {
		when(productRepository.findById("123")).thenReturn(Optional.of(product));
		Optional<Product> result = productService.getProduct("123");
		assertTrue(result.isPresent());
		assertEquals("mobile", result.get().getName());
		
	}
	@Test
	void testDeleteProduct() {
		productService.deleteProduct("123");
		verify(productRepository,times(1)).deleteById("123");
	}
	
	@Test
	void testGetallProducts() {
		
		List<Product> productList =  new ArrayList<Product>();
		productList.add(product);
		when(productRepository.findAll()).thenReturn(productList);
		List<Product> result = productService.getAll();
		assertEquals(1, result.size());
		assertEquals("mobile",result.get(0).getName());
	}
	@Test
	void testUpdateProduct() {
		when(productRepository.existsById("123")).thenReturn(true);
		when(productRepository.save(product)).thenReturn(product);
		Product updateProduct = productService.updateProduct("123", product);
		assertNotNull(updateProduct);
		assertEquals("mobile",product.getName());
	}
}
