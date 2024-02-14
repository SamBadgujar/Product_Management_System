package com.samadhan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samadhan.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

}
