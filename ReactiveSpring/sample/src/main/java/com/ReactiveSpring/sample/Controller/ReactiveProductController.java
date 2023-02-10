package com.ReactiveSpring.sample.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ReactiveSpring.sample.Entity.Product;
import com.ReactiveSpring.sample.Service.ReactiveProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class ReactiveProductController {
	
	@Autowired
	private ReactiveProductService reactiveProductService;

	@PostMapping("/reactiveproductmanagement/addProduct")
	public Mono<Product> addProduct(@RequestBody Product product) {
        return reactiveProductService.saveProduct(product);
    }
	
	@PostMapping("/reactiveproductmanagement/addProducts")
    public Flux<Product> addProducts(@RequestBody List<Product> products) {
        return reactiveProductService.saveProducts(products);
    }

    @GetMapping("/reactiveproductmanagement/getallproducts")
    public Flux<Product> findAllProducts() {
        return reactiveProductService.getProducts();
    }

    @GetMapping("/reactiveproductmanagement/findproductById/{id}")
    public Mono<Product> findProductById(@PathVariable int id) {
        return reactiveProductService.getProductById(id);
    }

    @GetMapping("/reactiveproductmanagement/findproductByName/{name}")
    public Mono<Product> findProductByName(@PathVariable String name) {
        return reactiveProductService.getProductByName(name);
    }

    @PutMapping("/reactiveproductmanagement/updateproduct")
    public Mono<Product> updateProduct(@PathVariable("id") final String id,@RequestBody Product product) {
        return reactiveProductService.updateProduct(id,product);
    }

    @DeleteMapping("/reactiveproductmanagement/deleteproduct/{id}")
    public Mono<Product> deleteProduct(@PathVariable int id) {
        return reactiveProductService.deleteProduct(id);
    }
}
