package com.example.crestaurante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crestaurante.repositories.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	private RequestRepository rRepo;
	
	@Override
	public void setTableToFinished(int table) {
		rRepo.setTableToFinished(table);
	}

}
