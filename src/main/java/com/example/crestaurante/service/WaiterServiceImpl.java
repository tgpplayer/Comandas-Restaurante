package com.example.crestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crestaurante.dto.WaiterDTO;
import com.example.crestaurante.mappers.WaiterMapper;
import com.example.crestaurante.repositories.WaiterRepository;

@Service
public class WaiterServiceImpl implements WaiterService{
	
	@Autowired
	private WaiterRepository cRepo;
	
	@Autowired
	private WaiterMapper wMapper;

	@Override
	public WaiterDTO identifyWaiter(int code) {
		WaiterDTO waiter = wMapper.toDTO(cRepo.getWaiterByCode(code));
		if(waiter != null) {
			return waiter;
		}
		return null;
	}

}
