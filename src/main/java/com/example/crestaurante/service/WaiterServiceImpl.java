package com.example.crestaurante.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crestaurante.dto.TopRankedWaiterDTO;
import com.example.crestaurante.dto.WaiterDTO;
import com.example.crestaurante.mappers.WaiterMapper;
import com.example.crestaurante.repositories.WaiterRepository;

@Service
public class WaiterServiceImpl implements WaiterService{
	
	@Autowired
	private WaiterRepository wRepo;
	
	@Autowired
	private WaiterMapper wMapper;

	@Override
	public WaiterDTO identifyWaiter(int code) {
		WaiterDTO waiter = wMapper.toDTO(wRepo.getWaiterByCode(code));
		if(waiter != null) {
			return waiter;
		}
		return null;
	}

	@Override
	public List<TopRankedWaiterDTO> getTopRankedWaitersInATimeRange(LocalDate fRange, LocalDate sRange) {
		return wRepo.getTopRankedWaitersInATimeRange(fRange, sRange);
	}

}
