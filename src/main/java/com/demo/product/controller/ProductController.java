package com.demo.product.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.product.resources.Product;
import com.demo.product.resources.ProductRequest;
import com.demo.product.resources.ProductResponse;
import com.demo.product.service.ProductService;


@RestController
@RequestMapping("/productdemo")
@Validated
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(path="/")
	public List<Product> getSellableProducts() {
		return productService.getSellableProducts();
	}
	
	@GetMapping(path="/product/name/{productname}")
	public Product getProduct(@NotBlank @PathVariable("productname") String productname) {
		return productService.getProduct(productname);
	}
	
	@GetMapping(path="/product/id/{productId}")
	public Product getProduct(@NotBlank @PathVariable("productId") int productId) {
		return productService.getProduct(productId);
	}
	
	@PutMapping("/")
	public ProductResponse placeOrder(@RequestBody ProductRequest orderRequest) {
		System.out.println("Order placed method called");
		return productService.createOrder(orderRequest);
	}
	
	@GetMapping("/sold")
	public ProductResponse soldProducts() {
		System.out.println("/sold method");
		return productService.getSoldProducts();
	}
	
	
	
}
