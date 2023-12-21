package com.example.crestaurante.dto;

import lombok.Data;

@Data
public class OrderDTO {

	private long id;
	private RequestDTO request;
	private ProductDTO product;
}
