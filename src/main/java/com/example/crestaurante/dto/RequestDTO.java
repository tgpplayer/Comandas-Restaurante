package com.example.crestaurante.dto;

import lombok.Data;

@Data
public class RequestDTO {
	
	private long id;
	private int tableNumber;
	private WaiterDTO waiter;
	private boolean finished;
}
