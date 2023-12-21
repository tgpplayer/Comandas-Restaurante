package com.example.crestaurante.dto;

import lombok.Data;

@Data
public class RequestDTO {
	
	private long id;
	private int table;
	private WaiterDTO waiter;
}
