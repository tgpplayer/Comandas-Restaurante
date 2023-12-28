package com.example.crestaurante.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RequestDTO {
	
	private long id;
	private int tableNumber;
	private WaiterDTO waiter;
	private LocalDate orderDate;
	private boolean finished;
}
