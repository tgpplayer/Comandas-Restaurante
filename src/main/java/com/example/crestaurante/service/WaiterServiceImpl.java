package com.example.crestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crestaurante.repositories.WaiterRepository;

@Service
public class WaiterServiceImpl implements WaiterService{
	
	@Autowired
	private WaiterRepository cRepo;

	@Override
	public String identifyWaiter(int code) {
		String waiterName = cRepo.getWaiterNameByCode(code);
		if(waiterName != null) {
			return waiterName;
		}
		return null;
	}

}
