package com.example.crestaurante.service;

import java.time.LocalDate;
import java.util.List;

import com.example.crestaurante.dto.TopRankedWaiterDTO;
import com.example.crestaurante.dto.WaiterDTO;

public interface WaiterService {
	WaiterDTO identifyWaiter(int code);
	List<TopRankedWaiterDTO> getTopRankedWaitersInATimeRange(LocalDate fRange, LocalDate sRange);
}
