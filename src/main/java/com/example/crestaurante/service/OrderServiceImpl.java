package com.example.crestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crestaurante.dto.OrderDTO;
import com.example.crestaurante.mappers.OrderMapper;
import com.example.crestaurante.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository oRepo;
	
	@Autowired
	private OrderMapper oMapper;

	@Override
	public void saveOrder(OrderDTO order) {
		oRepo.save(oMapper.toEntity(order));
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		return oMapper.toDTOList(oRepo.findAll());
	}

}
