package com.demo.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.product.resources.Product;

/**
 * 
 * @author Anuj Pankaj
 * 
 * JpaRepository to save and retrieval  of data from DB
 *
 */
@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer>{
	List<Product> findByProductName(String productName);
	Product findByProductId(int productId);
	List<Product> findAll();
}
