package com.SpringBoot.SampleSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.SampleSpringBoot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	 Product findByName(String name);
}
