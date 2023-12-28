package com.example.crestaurante.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crestaurante.dto.TopRankedWaiterDTO;
import com.example.crestaurante.dto.WaiterDTO;
import com.example.crestaurante.service.WaiterService;

@RestController
public class WaiterController {
	
	@Autowired
	private WaiterService wService;

	// We return the whole Waiter object because is needed for later orders
	@PostMapping("/auth-waiter")
	public ResponseEntity<WaiterDTO> authWaiter(@RequestParam int code) {
		WaiterDTO waiter = wService.identifyWaiter(code);
		
		if(waiter != null) {
			return ResponseEntity.status(HttpStatus.OK).body(waiter);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(waiter);
	}
	
	// Get the top ranked waiters at specific rank of time
	@PostMapping("/get-top-ranked-waiters")
	public ResponseEntity<List<TopRankedWaiterDTO>> getTopRankedWaitersInATimeRange(@RequestParam LocalDate fRange, @RequestParam LocalDate sRange) {
		return ResponseEntity.status(HttpStatus.OK).body(wService.getTopRankedWaitersInATimeRange(fRange, sRange));
	}
 }
