package com.demo.product.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.product.dao.ProductJpaRepository;
import com.demo.product.exception.ProductNotFoundException;
import com.demo.product.resources.Product;
import com.demo.product.resources.ProductRequest;
import com.demo.product.resources.ProductResponse;

/**
 * 
 * @author Anuj Pankaj
 * 
 * Service class to perform business logic for every requests that comes to ProductController
 *
 */
@Service
public class ProductService {

	@Autowired
	ProductJpaRepository productJpaRepository;
	
	/**
	 * It  returns every product that is sale able to user
	 * 
	 * @return Product ArrayList
	 */
	public List<Product> getSellableProducts() {
		return productJpaRepository.findAll().stream().filter(product->product.isSold()==false).collect(toList());
	}
	
	/**
	 * It returns single Product, while searching from user through product name
	 * 
	 * @param productName
	 * @return Product Object
	 */
	public Product getProduct(String productName) {
		return productJpaRepository.findByProductName(productName).stream().filter(product->product.getProductName().equalsIgnoreCase(productName)).findAny().orElseThrow(()-> new ProductNotFoundException(productName));
	}
	
	/**
	 * It returns single Product, while searching from user through product Id
	 * 
	 * @param productId
	 * @return Product Object
	 */
	public Product getProduct(int productId) {
		Product product = productJpaRepository.findByProductId(productId);
		if(product==null) {
			throw new RuntimeException(" Product found with this id  " + productId);
		}
		return product;
	}
	
	/**
	 * It creates an order with single or multiple product
	 * 
	 * @param orderRequest
	 * @return ProductResponse Object
	 */
	public ProductResponse createOrder(ProductRequest orderRequest) {
		System.out.println(" Order list " + orderRequest.getProductIds());
		
		List<Product> porudctList = new ArrayList<Product>();
		for (Integer productId : orderRequest.getProductIds()) {
			Product product =  productJpaRepository.findByProductId(productId);
			System.out.println(" Prodcut Id is " + productId);
			product.setSold(true);
			product.setSoldTo(orderRequest.getEmailId());
			porudctList.add(product);
		}
		List<Product> soldPorudctList =productJpaRepository.saveAll(porudctList);
		
		return  new ProductResponse(HttpStatus.OK, " congratulated your order palced successfully, please find you item list for this order  ", soldPorudctList.stream().map(product -> product.getProductName()).collect(toList()), new HashMap<>());
		
	}
	
	/**
	 * Returns All sold products for the all users and products are mapped with user email Id
	 * @return ProductResponse
	 */
	public ProductResponse getSoldProducts() {
		
		List<Product> soldPorudctList = productJpaRepository.findAll().stream().filter(product-> product.isSold()==true).collect(toList());
		
		Map<String, List<Product>>  productSoldMap = new HashMap<>();
		for (Product product : soldPorudctList) {
			
			if(productSoldMap.containsKey(product.getSoldTo())) {
				List<Product> productList = productSoldMap.get(product.getSoldTo());
				productList.add(product);
				productSoldMap.put(product.getSoldTo(), productList);
			} else {
				List<Product> productList = new ArrayList<>();
				productList.add(product);
				productSoldMap.put(product.getSoldTo(), productList);
			}
		}
		
		return new ProductResponse(HttpStatus.OK, "Sold Product from stocks ", new ArrayList<>(),productSoldMap);
	}
	
	
	/**
	 * Returns All products sold as well as non sold products for the all users and products are mapped with user email Id
	 * @return ProductResponse
	 */
	
	public ProductResponse getAllProducts() {
		
		Map<String, List<Product>>  productsMap = new HashMap<>();
		productsMap.put("Available prodcut stock", getSellableProducts());
		productsMap.putAll(getSoldProducts().getProductMap());
		
		
		return new ProductResponse(HttpStatus.OK, "Sold Product from stocks ", new ArrayList<>(),productsMap);
	}
	
}
