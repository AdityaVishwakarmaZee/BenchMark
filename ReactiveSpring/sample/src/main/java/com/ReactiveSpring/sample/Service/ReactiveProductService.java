package com.ReactiveSpring.sample.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReactiveSpring.sample.Entity.Product;
import com.ReactiveSpring.sample.Repository.ReactiveProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveProductService {

	@Autowired
	private ReactiveProductRepository reactiveProductRepository;
	
	public Mono<Product> saveProduct(Product product) {
        return reactiveProductRepository.save(product);
    }
	
	public Flux<Product> saveProducts(List<Product> products) {
        return reactiveProductRepository.saveAll(products);
    }

    public Flux<Product> getProducts() {
        return reactiveProductRepository.findAll();
    }

    public Mono<Product> getProductById(int id) {
        return reactiveProductRepository.findById(id);
    }

    public Mono<Product> getProductByName(String name) {
        return reactiveProductRepository.findByName(name);
    }

    public Mono<Product> deleteProduct(int id) {
    	return reactiveProductRepository.findById(id).doOnSuccess(
    			product -> reactiveProductRepository.delete(product).subscribe());
    }

    public Mono<Product> updateProduct(final String id,Product product) {
//        Mono<Product> existingProduct = reactiveProductRepository.findById(product.getId());
//        existingProduct.setName(product.getName());
//        existingProduct.setQuantity(product.getQuantity());
//        existingProduct.setPrice(product.getPrice());
        return reactiveProductRepository.save(product);
    }

}
