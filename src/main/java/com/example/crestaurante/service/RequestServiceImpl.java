package com.example.crestaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crestaurante.dto.RequestDTO;
import com.example.crestaurante.mappers.RequestMapper;
import com.example.crestaurante.repositories.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository rRepo;
	
	@Autowired
	private RequestMapper rMapper;
	
	@Override
	public void setTableToFinished(int table) {
		rRepo.setTableToFinished(table);
	}

	@Override
	public RequestDTO getRequest(int table) {
		return rMapper.toDTO(rRepo.getRequest(table));
	}

	@Override
	public List<Integer> getUnfinishedTables() {
		return rRepo.getUnfinishedTables();
	}

}
