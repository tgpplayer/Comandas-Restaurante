package com.example.crestaurante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crestaurante.service.WaiterService;

@RestController
public class WaiterController {
	
	@Autowired
	private WaiterService wService;

	@PostMapping("/auth-waiter")
	public ResponseEntity<String> authWaiter(@PathVariable int code) {
		String waiterName = wService.identifyWaiter(code);
		
		if(waiterName != null) {
			return ResponseEntity.status(HttpStatus.OK).body(waiterName);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(waiterName);
	}
}
