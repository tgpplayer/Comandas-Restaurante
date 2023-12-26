package com.example.crestaurante.dto;

import lombok.Data;

@Data
public class TopRankedProductDTO {
	
	private long id;
	private String product;
	private String category;
	private double price;
	private int timesOrdered;
}
