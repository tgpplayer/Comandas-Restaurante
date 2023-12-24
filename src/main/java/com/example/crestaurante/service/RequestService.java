package com.example.crestaurante.service;

import java.util.List;

import com.example.crestaurante.dto.RequestDTO;

public interface RequestService {
	void setTableToFinished(int table);
	RequestDTO getRequest(int table);
	List<Integer> getUnfinishedTables();
}
