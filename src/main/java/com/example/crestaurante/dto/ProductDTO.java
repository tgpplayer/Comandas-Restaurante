package com.example.crestaurante.dto;

import lombok.Data;

@Data
public class ProductDTO {
	
	private long id;
	private String product;
	private String category;
	private Double price;
}
