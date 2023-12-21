package com.example.crestaurante.service;

import java.util.List;

import com.example.crestaurante.dto.OrderDTO;

public interface OrderService {
	void saveOrder(OrderDTO order);
	List<OrderDTO> getAllOrders();
}
