package com.ReactiveSpring.sample.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {

	@Id
	public int id;
	
	public String name;
	public int quantity;
	public double price;
	
}

