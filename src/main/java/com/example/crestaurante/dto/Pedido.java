package com.example.crestaurante.dto;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pedido {
	
	private long id;
	private int mesa;
	private String camarero;
	private HashMap<String, Double> comidasBebidas;
	private Double precio;
}
