package com.ReactiveSpring.sample.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.ReactiveSpring.sample.Entity.Product;

import reactor.core.publisher.Mono;

public interface ReactiveProductRepository extends ReactiveCrudRepository<Product, Integer>{

	 Mono<Product> findByName(String name);
}
